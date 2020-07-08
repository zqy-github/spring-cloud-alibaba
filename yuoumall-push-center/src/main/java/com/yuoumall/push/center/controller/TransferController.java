package com.yuoumall.push.center.controller;

import com.yuoumall.push.center.model.ReturnY;
import com.yuoumall.push.center.entity.bto.SD001.SD001SCREQ;
import com.yuoumall.push.center.entity.bto.SD002.SD002SCREQ;
import com.yuoumall.push.center.entity.bto.SD003.SD003SCREQ;
import com.yuoumall.push.center.util.HttpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
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

    @ApiOperation(value = "SD001-销售订单创建接口")
    @PostMapping("/SD001")
    public ReturnY SD001(@RequestBody SD001SCREQ mara) {
        ReturnY ReturnY = null;
        if (mara.getDT_SD001_SC_REQ() != null) {
            ReturnY = HttpUtil.sendDatas("SD001", mara);
        }
        return ReturnY == null ? new ReturnY(ReturnY.FAIL_CODE, "请求参数异常") : ReturnY;
    }

    @ApiOperation(value = "SD002-服务订单创建接口")
    @PostMapping("/SD002")
    public ReturnY SD002(@RequestBody SD002SCREQ vbap) {
        ReturnY ReturnY = null;
        if (vbap.getDT_SD002_SC_REQ() != null) {
            ReturnY = HttpUtil.sendDatas("SD002", vbap);
        }
        return ReturnY == null ? new ReturnY(ReturnY.FAIL_CODE, "请求参数异常") : ReturnY;
    }

    @ApiOperation(value = "SD003-退货订单创建接口")
    @PostMapping("/SD003")
    public ReturnY SD003(@RequestBody SD003SCREQ vbak) {
        ReturnY ReturnY = null;
        if (vbak.getDT_SD003_SC_REQ() != null) {
            ReturnY = HttpUtil.sendDatas("SD003", vbak);
        }
        return ReturnY == null ? new ReturnY(ReturnY.FAIL_CODE, "请求参数异常") : ReturnY;
    }
}
