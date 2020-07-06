package com.yuoumall.push.center.util;

import com.xxl.job.core.biz.model.ReturnT;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;

/**
 * @Author ZQY
 * @Date 2020/7/1
 * @Version 1.0
 * @Description 单请求（同步）
 */

public class HttpUtil {

    @Value("${po.host.url}")
    private static String hostUrl;

    @Value("${po.host.port}")
    private static String hostPort;

    @Value("${po.au.username}")
    private static String userName;

    @Value("${po.au.password}")
    private static String password;

    public static String httpPostWithjson(String url, String json) {
        String result = "";
        url = hostUrl + ":" + hostPort + url;
        HttpPost httpPost = new HttpPost(url);

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
            String user = userName + ":" + password;
            String encoding = DatatypeConverter.printBase64Binary(user.getBytes("UTF-8"));
            httpPost.setHeader("Authorization", "Basic " + encoding);

            //执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = httpClient.execute(httpPost);
            //获取结果实体
            HttpEntity rpEntity = response.getEntity();
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

    public static ReturnT sendDatas(String port, Object object, Long startTs) {
        String PoUrl = "/RESTAdapter/" + port;
        String msg = "开始请求PO连接：" + PoUrl;
        logs(msg);
        JSONObject jsonObject = JSONObject.fromObject(object);
        String result = HttpUtil.httpPostWithjson(PoUrl, jsonObject.toString());

        if (result == null) {
            Long endTs = System.currentTimeMillis();
            msg = "请求PO异常, 结束, 耗时 :" + (endTs - startTs);
            logs(msg);
            return new ReturnT(ReturnT.FAIL_CODE,"请求PO异常, 结束");
        }
        msg = "获取到的PO返回参数 :" + result;
        logs(msg);

        Long endTs = System.currentTimeMillis();
        msg = "结束，耗时 :" + (endTs - startTs);
        logs(msg);
        return new ReturnT(ReturnT.SUCCESS_CODE, result);
    }

    public static void logs(String msg) {
        System.out.println(msg);
    }
}
