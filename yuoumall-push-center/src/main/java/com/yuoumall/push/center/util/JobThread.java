package com.yuoumall.push.center.util;

import com.yuoumall.push.center.jobhandler.POJobHandler;
import com.yuoumall.push.center.model.ReturnY;
import lombok.SneakyThrows;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description 多线程请求（异步）
 */
public class JobThread {
    public static void runJobThread(List list, String PoUrl, Long startTs) throws UnsupportedEncodingException {
        if (list.size() > 0) {
            ExecutorService es = Executors.newFixedThreadPool(list.size());
            for (Object object : list) {
                Runnable r = new Runnable() {
                    @SneakyThrows
                    public void run() {
                        ReturnY result = HttpUtil.sendDatas(PoUrl, object);
                        String inMsg = "XXL-JOB, 获取到的PO返回参数 :" + result.toString();
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
