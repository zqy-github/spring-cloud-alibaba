package com.yuoumall.push.center.util;

import com.yuoumall.push.center.jobhandler.POJobHandler;
import lombok.SneakyThrows;
import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
public class JobThread {
    public static void runJobThread(List<Object> list, String PoUrl, Long startTs) throws UnsupportedEncodingException {
        if (list.size() > 0) {
            ExecutorService es = Executors.newFixedThreadPool(list.size());
            for (Object object : list) {
                Runnable r = new Runnable() {
                    @SneakyThrows
                    public void run() {
                        JSONObject jsonObject = JSONObject.fromObject(object);
                        String result = Httputil.httpPostWithjson(PoUrl, jsonObject.toString());
                        String inMsg = "XXL-JOB, 获取到的PO返回参数 :" + result;
                        POJobHandler.logs(inMsg);
                    }
                };
                es.submit(r);
            }
            // 多线程释放
            es.shutdown();

            Long endTs = System.currentTimeMillis();
            String msg = "XXL-JOB, 结束，耗时 :" + (endTs - startTs);
            POJobHandler.logs(msg);
        }
    }
}
