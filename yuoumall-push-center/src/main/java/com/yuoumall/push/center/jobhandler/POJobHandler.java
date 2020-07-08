package com.yuoumall.push.center.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.yuoumall.push.center.entity.bto.SD001.SD001SCREQ;
import com.yuoumall.push.center.entity.bto.SD002.SD002SCREQ;
import com.yuoumall.push.center.entity.bto.SD003.SD003SCREQ;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.yuoumall.push.center.model.ReturnY;
import com.yuoumall.push.center.service.MaraService;
import com.yuoumall.push.center.service.VbakService;
import com.yuoumall.push.center.service.VbapService;
import com.yuoumall.push.center.util.SpringContextUtil;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
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
        ReturnT<String> result = null;
        for (Method m : POJobHandler.class.getMethods()) {
            if (m.getName().indexOf(param) == 0) {
                if (POJobHandler.getInstance() == null) {
                    instance = new POJobHandler();
                }
                result = (ReturnT) m.invoke(instance);
            }
        }
        return result;
    }

    public ReturnY SD001() throws Exception {
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB, Join Method " + " 任务开始时间:" + startTs);

        // 手动注入bean
        MaraService maraService = SpringContextUtil.getBean(MaraService.class);

        List<SD001SCREQ> maraList = maraService.selectFormatMaraByStatusNo();

        logs("XXL-JOB, 获取到源数据:" + maraList.toString());

        String PoUrl = "SD001";
        logs("XXL-JOB 开始请求PO连接：" + PoUrl);

        runJobThread(maraList, PoUrl, startTs);
        return new ReturnY(ReturnY.SUCCESS_CODE, "end");
    }

    public ReturnY SD002() throws Exception {
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB, Join Method " + " 任务开始时间:" + startTs);

        // 手动注入bean
        VbapService vbapService = SpringContextUtil.getBean(VbapService.class);

        List<SD002SCREQ> vbapList = vbapService.selectFormatVbapByStatusNo();

        logs("XXL-JOB, 获取到源数据:" + vbapList.toString());

        String PoUrl = "SD002";
        logs("XXL-JOB 开始请求PO连接：" + PoUrl);

        runJobThread(vbapList, PoUrl, startTs);
        return new ReturnY(ReturnY.SUCCESS_CODE, "end");
    }

    public ReturnY SD003() throws Exception {
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB, Join Method " + " 任务开始时间:" + startTs);

        // 手动注入bean
        VbakService vbakService = SpringContextUtil.getBean(VbakService.class);

        List<SD003SCREQ> vbakList = vbakService.selectFormatVbakByStatusNo();

        logs("XXL-JOB, 获取到源数据:" + vbakList.toString());

        String PoUrl = "SD001";
        logs("XXL-JOB 开始请求PO连接：" + PoUrl);

        runJobThread(vbakList, PoUrl, startTs);
        return new ReturnY(ReturnY.SUCCESS_CODE, "end");
    }


    public static void logs(String msg) throws UnsupportedEncodingException {
        XxlJobLogger.log(new String(msg.getBytes("gbk"), "utf-8"));
        System.out.println(msg);
    }

}
