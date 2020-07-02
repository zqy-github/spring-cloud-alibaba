package com.yuoumall.push.center.jobhandler;


import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.yuoumall.push.center.bo.Admin;
import com.yuoumall.push.center.service.AdminService;
import com.yuoumall.push.center.util.Httputil;

import org.json.JSONArray;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloJobHandler extends IJobHandler {

    @Autowired
    private AdminService adminService;

    @Override
    @XxlJob("SD001")
    public ReturnT<String> execute(String param) throws Exception {
        Long startTs = System.currentTimeMillis();
        XxlJobLogger.log("XXL-JOB, Join Method param :" + param + " 任务开始时间:" + startTs);
        System.out.println("XXL-JOB, Join Method. param : " + param + " 任务开始时间:" + startTs);
        Admin admin = new Admin();
        try {
            admin = adminService.selectByPrimaryKey(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        XxlJobLogger.log("XXL-JOB, 获取数据源:" + admin.toString());
        System.out.println("XXL-JOB, 获取数据源:" + admin.toString());

        String PoUrl = "http://sap-pod.yuou.com:50000/RESTAdapter/SD001";
        XxlJobLogger.log("XXL-JOB 开始请求PO连接：" + PoUrl);
        System.out.println("XXL-JOB 开始请求PO连接：" + PoUrl);

        // 请求po
        JSONObject jsonObject = JSONObject.fromObject(admin);
        String result = Httputil.httpPostWithjson(PoUrl, jsonObject.toString());

        XxlJobLogger.log("XXL-JOB, 获取到的PO返回参数 :" + result);
        System.out.println("XXL-JOB, 获取到的PO返回参数 : " + result);

        JSONArray jsonArray = new JSONArray(result);

        Long endTs = System.currentTimeMillis();

        XxlJobLogger.log("XXL-JOB, 耗时 :" + (endTs - startTs));
        System.out.println("XXL-JOB, 耗时 : " + (endTs - startTs));

        return new ReturnT(jsonArray.toString());
    }

}
