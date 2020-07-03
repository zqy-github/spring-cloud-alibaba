package com.yuoumall.push.center.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.yuoumall.push.center.bo.Admin;
import com.yuoumall.push.center.bo.HttpMara;
import com.yuoumall.push.center.bo.Mara;
import com.yuoumall.push.center.service.AdminService;
import com.yuoumall.push.center.service.MaraService;
import com.yuoumall.push.center.service.imp.AdminServiceImp;
import com.yuoumall.push.center.util.Httputil;
import com.yuoumall.push.center.util.SpringContextUtil;
import org.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

@Component
public class HelloJobHandler extends IJobHandler {

    private static HelloJobHandler instance = new HelloJobHandler();

    private HelloJobHandler() {
    }

    public static HelloJobHandler getInstance() {
        return instance;
    }

    @Autowired
    private AdminService adminService;

    @Override
    @XxlJob("SD")
    public ReturnT<String> execute(String param) throws Exception {
        String result = null;
        for (Method m : HelloJobHandler.class.getMethods()) {
            if (m.getName().indexOf(param) == 0) {
                if (HelloJobHandler.getInstance() == null) {
                    instance = new HelloJobHandler();
                }
                result = (String) m.invoke(instance);
            }
        }
        return new ReturnT(result);
    }

//    @XxlJob("SD001")
    public ReturnT<String> SD001() throws Exception {
        Long startTs = System.currentTimeMillis();
        String msg = "XXL-JOB, Join Method " + " 任务开始时间:" + startTs;
        logs(msg);
        // 手动注入bean
        MaraService maraService = (MaraService) SpringContextUtil.getBean(MaraService.class);
        HttpMara mara = null;
        try {
            mara = maraService.selectFormatMaraByPrimaryKey(1);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnT(ReturnT.FAIL_CODE, "获取失败");
        }
        msg = "XXL-JOB, 获取数据源:" + mara.toString();
        logs(msg);

        String PoUrl = "http://sap-pod.yuou.com:50000/RESTAdapter/SD001";
        msg = "XXL-JOB 开始请求PO连接：" + PoUrl;
        logs(msg);

        // 请求po
        JSONObject jsonObject = JSONObject.fromObject(mara);
        String result = Httputil.httpPostWithjson(PoUrl, jsonObject.toString());
        msg = "XXL-JOB, 获取到的PO返回参数 :" + result;
        logs(msg);

        JSONArray jsonArray = null;
        if (result != null && result != "") {
            jsonArray = new JSONArray(result);
        }
        Long endTs = System.currentTimeMillis();

        msg = "XXL-JOB, 结束，耗时 :" + (endTs - startTs);
        logs(msg);

        return new ReturnT(jsonArray == null ? "" : jsonArray.toString());
    }


    public static void logs(String msg) throws UnsupportedEncodingException {
        XxlJobLogger.log(new String(msg.getBytes("gbk"), "utf-8"));
        System.out.println(msg);
    }

}
