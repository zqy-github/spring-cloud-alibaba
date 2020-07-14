package com.yuoumall.push.center.util;

import com.yuoumall.push.center.entity.bo.common.Status;
import com.yuoumall.push.center.model.ReturnY;
import com.yuoumall.push.center.service.*;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;

/**
 * @Author ZQY
 * @Date 2020/7/1
 * @Version 1.0
 * @Description 单请求（同步）
 */

@Component
@PropertySource({"classpath:application.properties"})
public class HttpUtil {

    @Value("${po.host.url}")
    private String hostUrl;

    @Value("${po.host.port}")
    private String hostPort;

    @Value("${po.au.username}")
    private String userName;

    @Value("${po.au.password}")
    private String password;

    public static String httpPostWithjson(String url, String json) {
        String result = "";
        HttpUtil util = SpringContextUtil.getBean(HttpUtil.class);
        url = "http://" + util.hostUrl + ":" + util.hostPort + url;
        HttpPost httpPost = new HttpPost(url);
        logs("初始化请求地址：" + url);
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            StringEntity rqEntity = new StringEntity(json, "utf-8");//解决中文乱码问题
            rqEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            rqEntity.setContentType("application/json");
            // 设置超时时间
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000).setConnectTimeout(3000).build();
            httpPost.setConfig(requestConfig);
            // 设置请求内容
            httpPost.setEntity(rqEntity);
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            // 设置帐号密码
            String user = util.userName + ":" + util.password;
            String encoding = DatatypeConverter.printBase64Binary(user.getBytes("UTF-8"));
            httpPost.setHeader("Authorization", "Basic " + encoding);

            //执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = httpClient.execute(httpPost);
            //获取结果实体
            HttpEntity rpEntity = response.getEntity();
//            int status = response.getStatusLine().getStatusCode();
            if (rpEntity != null) {
                //按指定编码转换结果实体为String类型
                result = EntityUtils.toString(rpEntity);
            }
            EntityUtils.consume(rpEntity);
            //释放链接
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ReturnY sendDatas(String path, Object object, int type) {
        Long startTs = System.currentTimeMillis();
        String PoUrl = "/RESTAdapter/" + path;
        logs("开始请求PO连接：" + PoUrl);
        JSONObject jsonObject = JSONObject.fromObject(object);
        String result = HttpUtil.httpPostWithjson(PoUrl, jsonObject.toString());

        if (result == null) {
            Long endTs = System.currentTimeMillis();
            logs("请求PO异常, 结束, 耗时 :" + (endTs - startTs));
            return new ReturnY(ReturnY.FAIL_CODE, "请求PO异常, 结束");
        }

        logs("获取到的PO返回参数 :" + result);
        String rtcod = null;
        try {
            JSONObject resultJson = JSONObject.fromObject(result);
            logs("PO返回参数转换为json :" + resultJson.toString());
            rtcod = resultJson.getJSONObject("RETURN").getString("RTCOD");
            // 记录请求信息
            if (type == 1) {
                saveOrUpdateData(object, resultJson, path);
            }
        } catch (Exception e) {
            logs("PO返回参数转换为json异常, 结束");
        }
        Long endTs = System.currentTimeMillis();
        logs("结束，耗时 :" + (endTs - startTs));
        return new ReturnY(ReturnY.SUCCESS_CODE, rtcod, result);
    }

    public static void saveOrUpdateData(Object object, JSONObject resultJson, String ifcType) {
        //获取 TRANS_KEY
        JSONObject jsonObject = JSONObject.fromObject(JSONObject.fromObject(object).getString("HEAD"));
        String transKey = (String) jsonObject.get("TRANS_KEY");

        String rtcod = resultJson.getJSONObject("RETURN").getString("RTCOD");
        logs("PO请求返回结果 :" + rtcod);
        SapService sapService = SpringContextUtil.getBean(SapService.class);
        if (rtcod.equalsIgnoreCase("S")) {
            // 成功 处理数据库结果
            logs("PO请求--成功--！获取到transKey :" + transKey + " ifcType:" + ifcType + " 修改数据状态及添加成功日志");
            sapService.updateStatusSuccess(ifcType, transKey, rtcod);
        } else {
            // 记录失败信息
            logs("PO请求--失败--！获取到transKey :" + transKey + " ifcType:" + ifcType + " 添加失败日志及次数");
            String rtmsg = resultJson.getJSONObject("RETURN").getString("RTMSG");
            sapService.insertLostNum(ifcType, transKey, rtmsg, rtcod);
        }
    }

    public static void logs(String msg) {
        System.out.println(msg);
    }
}
