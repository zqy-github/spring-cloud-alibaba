package com.yuoumall.push.center.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.yuoumall.push.center.model.ReturnY;
import com.yuoumall.push.center.service.*;
import com.yuoumall.push.center.util.SpringContextUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.yuoumall.push.center.util.JobThread.runJobThread;

@Component
public class POJobHandler extends IJobHandler {

    private static POJobHandler instance = new POJobHandler();

    private POJobHandler() {
    }

    public static POJobHandler getInstance() {
        return instance;
    }

    @Override
    @XxlJob("SD2SC")
    public ReturnT<String> execute(String param) throws Exception {
        return SD(param);
    }

    public ReturnT<String> SD(String method) throws Exception {
        logs("----------------  XXL-JOB-" + method + " start -------------------------");
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB-" + method + ", Join Method " + " 任务开始时间:" + startTs);
        // 手动注入bean
        SapService sapService = SpringContextUtil.getBean(SapService.class);

        List<JSONObject> objectList = sapService.selectFormatDataByMethodStatusNo(method);
        if (objectList.get(0).get("HEAD") != null) {
            logs("XXL-JOB-" + method + ", 获取到源数据:" + objectList.toString());

            logs("XXL-JOB-" + method + ", 开始请求PO连接：" + method);

            runJobThread(objectList, method, startTs);
        } else {
            logs("XXL-JOB-" + method + ", 没有获取到需要执行数据");
        }
        logs("----------------  XXL-JOB-" + method + " end-------------------------");
        return new ReturnT<String>(ReturnY.SUCCESS_CODE, "end");
    }

    @XxlJob("SD002")
    public ReturnT<String> SD002(String param) throws Exception {
        logs("----------------  XXL-JOB-SD002 start-------------------------");
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB-SD002, Join Method " + " 任务开始时间:" + startTs);
        // 手动注入bean


        List vbapList = new ArrayList();
        if (vbapList.size() > 0) {
            logs("XXL-JOB-SD002, 获取到源数据:" + vbapList.toString());

            String PoUrl = "SD002";
            logs("XXL-JOB-SD002, 开始请求PO连接：" + PoUrl);

            runJobThread(vbapList, PoUrl, startTs);
        } else {
            logs("XXL-JOB-SD002, 没有需要执行数据");
        }
        logs("----------------  XXL-JOB-SD002 end-------------------------");
        return new ReturnT<String>(ReturnY.SUCCESS_CODE, "end");
    }

    public static void logs(String msg) throws UnsupportedEncodingException {
        XxlJobLogger.log(new String(msg.getBytes("gbk"), "utf-8"));
        System.out.println(msg);
    }

}
