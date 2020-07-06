package com.yuoumall.push.center.controller;

import com.xxl.job.core.biz.model.ReturnT;
import com.yuoumall.push.center.entity.bto.SD002SCREQ;
import com.yuoumall.push.center.util.HttpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ZQY
 * @Date 2020/7/6
 * @Version 1.0
 * @Description
 */

@RestController
@RequestMapping("/transfer")
@Slf4j
@Api(tags = "PO")
public class TransferController {

    @ApiOperation(value = "SD002")
    @RequestMapping("/SD002")
    public ReturnT SD002(@RequestBody SD002SCREQ vbap) {
        Long startTs = System.currentTimeMillis();
        String msg = "XXL-JOB, Join Method " + " 任务开始时间:" + startTs;
        logs(msg);
        ReturnT returnT = new ReturnT(ReturnT.FAIL_CODE, "请求参数异常");
        if (vbap.getDT_SD002_SC_REQ() != null) {
            returnT = HttpUtil.sendDatas("SD002", vbap, startTs);
        }
        return returnT;
    }


    public void logs(String msg) {
        System.out.println(msg);
    }
}
