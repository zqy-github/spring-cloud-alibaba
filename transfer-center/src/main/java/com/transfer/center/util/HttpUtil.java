package com.transfer.center.util;

import com.transfer.center.model.Return;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
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
@PropertySource({"classpath:application.yml"})
public class HttpUtil {

    @Value("${po.host.url}")
    private String hostUrl;

    @Value("${po.host.port}")
    private String hostPort;

    @Value("${po.au.username}")
    private String userName;

    @Value("${po.au.password}")
    private String password;

    public static String httpPostWithjson(String json) {
        String result = "";
        HttpUtil util = SpringContextUtil.getBean(HttpUtil.class);
        String url = "http://" + util.hostUrl + ":" + util.hostPort + "/RESTAdapter/MM006A";
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

    public static String sendDatas(String object) {
        Long startTs = System.currentTimeMillis();
        logs("身份验证通过，开始请求PO信息 : start --- " + startTs + " ---");
        String result = HttpUtil.httpPostWithjson(object);
        logs("获取到的PO返回参数 :" + result);
        Long endTs = System.currentTimeMillis();
        logs("结束，耗时 : end --- " + (endTs - startTs) + " ---");
        return result;
    }


    public static void logs(String msg) {
        System.out.println(msg);
    }
}
