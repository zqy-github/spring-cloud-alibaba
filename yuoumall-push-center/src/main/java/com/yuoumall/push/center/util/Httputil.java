package com.yuoumall.push.center.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Httputil {
    public static String httpPostWithjson(String url, String json) throws IOException {
        String result = "";
        HttpPost httpPost = new HttpPost(url);
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            StringEntity rqEntity = new StringEntity(json, "utf-8");//解决中文乱码问题
            rqEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            rqEntity.setContentType("application/json");
            httpPost.setEntity(rqEntity);
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

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
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
