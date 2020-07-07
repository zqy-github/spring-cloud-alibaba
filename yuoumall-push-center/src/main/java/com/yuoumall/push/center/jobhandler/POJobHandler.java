package com.yuoumall.push.center.jobhandler;

import com.yuoumall.push.center.entity.bto.SD001.SD001SCREQ;
import com.yuoumall.push.center.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.yuoumall.push.center.entity.bo.SD001.HttpMara;
import com.yuoumall.push.center.service.MaraService;
import com.yuoumall.push.center.util.HttpUtil;
import com.yuoumall.push.center.util.SpringContextUtil;
import org.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
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
    public ReturnT execute(String param) throws Exception {
        String result = null;
        for (Method m : POJobHandler.class.getMethods()) {
            if (m.getName().indexOf(param) == 0) {
                if (POJobHandler.getInstance() == null) {
                    instance = new POJobHandler();
                }
                result = (String) m.invoke(instance);
            }
        }
        return new ReturnT(result);
    }

    public ReturnT SD001() throws Exception {
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB, Join Method " + " 任务开始时间:" + startTs);

        // 手动注入bean
        MaraService maraService = SpringContextUtil.getBean(MaraService.class);

        List<SD001SCREQ> mara = maraService.selectFormatMaraByStatusNo();

        logs("XXL-JOB, 获取到源数据:" + mara.toString());

        String PoUrl = "SD001";
        logs("XXL-JOB 开始请求PO连接：" + PoUrl);

        if (mara instanceof List) {
            runJobThread(mara, PoUrl, startTs);
            return new ReturnT(ReturnT.SUCCESS_CODE, "end");
        } else {
            // 请求po
            JSONObject jsonObject = JSONObject.fromObject(mara);
            String result = HttpUtil.httpPostWithjson(PoUrl, jsonObject.toString());

            logs("XXL-JOB, 获取到的PO返回参数 :" + result);

            Long endTs = System.currentTimeMillis();
            logs("XXL-JOB, 结束，耗时 :" + (endTs - startTs));

            return new ReturnT(result == null ? "" : result);
        }
    }


    public static void logs(String msg) throws UnsupportedEncodingException {
        XxlJobLogger.log(new String(msg.getBytes("gbk"), "utf-8"));
        System.out.println(msg);
    }

}
