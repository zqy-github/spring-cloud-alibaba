package com.yuoumall.push.center.jobhandler;


import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import com.yuoumall.push.center.bo.Admin;
import com.yuoumall.push.center.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloJobHandler extends IJobHandler {

    @Autowired
    private AdminService adminService;

    @Override
    @XxlJob("SD001")
    public ReturnT<String> execute(String param)throws Exception {
        XxlJobLogger.log("XXL-JOB, Join Method param :" + param);
        System.out.println("XXL-JOB, Join Method. param : " + param);
        Admin admin = new Admin();
        try {
            admin = adminService.selectByPrimaryKey(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        XxlJobLogger.log("XXL-JOB, get object :" + admin.toString());
        System.out.println("XXL-JOB, get object :" + admin.toString());
        return new ReturnT(admin);
    }

}
