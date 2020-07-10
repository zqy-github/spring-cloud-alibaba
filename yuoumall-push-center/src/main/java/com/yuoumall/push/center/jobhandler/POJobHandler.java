package com.yuoumall.push.center.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.yuoumall.push.center.entity.bto.FI010.FI010SCREQ;
import com.yuoumall.push.center.entity.bto.FI011.FI011SCREQ;
import com.yuoumall.push.center.entity.bto.FI029.FI029SCREQ;
import com.yuoumall.push.center.entity.bto.SD001.SD001SCREQ;
import com.yuoumall.push.center.entity.bto.SD002.SD002SCREQ;
import com.yuoumall.push.center.entity.bto.SD003.SD003SCREQ;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.yuoumall.push.center.model.ReturnY;
import com.yuoumall.push.center.service.*;
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
        logs("----------------  XXL-JOB-SD001 start -------------------------");
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB-SD001, Join Method " + " 任务开始时间:" + startTs);
        // 手动注入bean
        MaraService maraService = SpringContextUtil.getBean(MaraService.class);

        List<SD001SCREQ> maraList = maraService.selectFormatMaraByStatusNo();
        if (maraList.size() > 0) {
            logs("XXL-JOB-SD001, 获取到源数据:" + maraList.toString());

            String PoUrl = "SD001";
            logs("XXL-JOB-SD001, 开始请求PO连接：" + PoUrl);

            runJobThread(maraList, PoUrl, startTs);
        } else {
            logs("XXL-JOB-SD001, 没有需要执行数据");
        }
        logs("----------------  XXL-JOB-SD001 end-------------------------");
        return new ReturnY(ReturnY.SUCCESS_CODE, "end");
    }

    public ReturnY SD002() throws Exception {
        logs("----------------  XXL-JOB-SD002 start-------------------------");
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB-SD002, Join Method " + " 任务开始时间:" + startTs);
        // 手动注入bean
        VbapService vbapService = SpringContextUtil.getBean(VbapService.class);

        List<SD002SCREQ> vbapList = vbapService.selectFormatVbapByStatusNo();
        if (vbapList.size() > 0) {
            logs("XXL-JOB-SD002, 获取到源数据:" + vbapList.toString());

            String PoUrl = "SD002";
            logs("XXL-JOB-SD002, 开始请求PO连接：" + PoUrl);

            runJobThread(vbapList, PoUrl, startTs);
        } else {
            logs("XXL-JOB-SD002, 没有需要执行数据");
        }
        logs("----------------  XXL-JOB-SD002 end-------------------------");
        return new ReturnY(ReturnY.SUCCESS_CODE, "end");
    }

    public ReturnY SD003() throws Exception {
        logs("----------------  XXL-JOB-SD003 start-------------------------");
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB-SD003, Join Method " + " 任务开始时间:" + startTs);

        // 手动注入bean
        VbakService vbakService = SpringContextUtil.getBean(VbakService.class);

        List<SD003SCREQ> vbakList = vbakService.selectFormatVbakByStatusNo();
        if (vbakList.size() > 0) {
            logs("XXL-JOB-SD003, 获取到源数据:" + vbakList.toString());

            String PoUrl = "SD001";
            logs("XXL-JOB-SD003, 开始请求PO连接：" + PoUrl);

            runJobThread(vbakList, PoUrl, startTs);
        } else {
            logs("XXL-JOB-SD003, 没有需要执行数据");
        }
        logs("----------------  XXL-JOB-SD003 end-------------------------");
        return new ReturnY(ReturnY.SUCCESS_CODE, "end");
    }

    public ReturnY FI010() throws Exception {
        logs("----------------  XXL-JOB-FI010 start-------------------------");
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB-SD003, Join Method " + " 任务开始时间:" + startTs);

        // 手动注入bean
        RebateService rebateService = SpringContextUtil.getBean(RebateService.class);

        List<FI010SCREQ> rebateList = rebateService.selectFormatRebateByStatusNo();
        if (rebateList.size() > 0) {
            logs("XXL-JOB-FI010, 获取到源数据:" + rebateList.toString());

            String PoUrl = "SD001";
            logs("XXL-JOB-FI010, 开始请求PO连接：" + PoUrl);

            runJobThread(rebateList, PoUrl, startTs);
        } else {
            logs("XXL-JOB-FI010, 没有需要执行数据");
        }
        logs("----------------  XXL-JOB-FI010 end-------------------------");
        return new ReturnY(ReturnY.SUCCESS_CODE, "end");
    }

    public ReturnY FI011() throws Exception {
        logs("----------------  XXL-JOB-FI011 start-------------------------");
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB-SD003, Join Method " + " 任务开始时间:" + startTs);

        // 手动注入bean
        ServiceChargeService chargeService = SpringContextUtil.getBean(ServiceChargeService.class);

        List<FI011SCREQ> chargeList = chargeService.selectFormatServiceChargeByStatusNo();
        if (chargeList.size() > 0) {
            logs("XXL-JOB-FI011, 获取到源数据:" + chargeList.toString());

            String PoUrl = "SD001";
            logs("XXL-JOB-FI011, 开始请求PO连接：" + PoUrl);

            runJobThread(chargeList, PoUrl, startTs);
        } else {
            logs("XXL-JOB-FI011, 没有需要执行数据");
        }
        logs("----------------  XXL-JOB-FI011 end-------------------------");
        return new ReturnY(ReturnY.SUCCESS_CODE, "end");
    }

    public ReturnY FI029() throws Exception {
        logs("----------------  XXL-JOB-FI011 start-------------------------");
        Long startTs = System.currentTimeMillis();
        logs("XXL-JOB-FI029, Join Method " + " 任务开始时间:" + startTs);

        // 手动注入bean
        ReceiptService receiptService = SpringContextUtil.getBean(ReceiptService.class);

        List<FI029SCREQ> receiptList = receiptService.selectFormatReceiptByStatusNo();
        if (receiptList.size() > 0) {
            logs("XXL-JOB-FI029, 获取到源数据:" + receiptList.toString());

            String PoUrl = "SD001";
            logs("XXL-JOB-FI029, 开始请求PO连接：" + PoUrl);

            runJobThread(receiptList, PoUrl, startTs);
        } else {
            logs("XXL-JOB-FI029, 没有需要执行数据");
        }
        logs("----------------  XXL-JOB-FI011 end-------------------------");
        return new ReturnY(ReturnY.SUCCESS_CODE, "end");
    }


    public static void logs(String msg) throws UnsupportedEncodingException {
        XxlJobLogger.log(new String(msg.getBytes("gbk"), "utf-8"));
        System.out.println(msg);
    }

}
