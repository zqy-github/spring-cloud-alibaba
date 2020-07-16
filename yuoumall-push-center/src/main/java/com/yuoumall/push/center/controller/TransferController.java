package com.yuoumall.push.center.controller;

import com.yuoumall.push.center.entity.bto.FI010.RqHttpRebate;
import com.yuoumall.push.center.entity.bto.FI011.RqHttpServiceCharge;
import com.yuoumall.push.center.entity.bto.FI029.RqHttpReceipt;
import com.yuoumall.push.center.entity.bto.SD001.RqHttpMara;
import com.yuoumall.push.center.entity.bto.SD002.RqHttpVbap;
import com.yuoumall.push.center.entity.bto.SD003.RqHttpVbak;
import com.yuoumall.push.center.model.ReturnY;
import com.yuoumall.push.center.util.HttpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "SD002-服务订单创建接口")
    @PostMapping("/SD002")
    public ReturnY SD002(@RequestBody RqHttpVbap vbap) {
        ReturnY ReturnY = null;
        if (vbap.getHead() != null) {
            ReturnY = HttpUtil.sendDatas("SD002", vbap, 2);
        }
        return ReturnY == null ? new ReturnY(ReturnY.FAIL_CODE, "请求参数异常") : ReturnY;
    }

    @ApiOperation(value = "SD003-退货订单创建接口")
    @PostMapping("/SD003")
    public ReturnY SD003(@RequestBody RqHttpVbak vbak) {
        ReturnY ReturnY = null;
        if (vbak.getHead() != null) {
            ReturnY = HttpUtil.sendDatas("SD003", vbak, 2);
        }
        return ReturnY == null ? new ReturnY(ReturnY.FAIL_CODE, "请求参数异常") : ReturnY;
    }

    @ApiOperation(value = "FI010-销售返利接口")
    @PostMapping("/FI010")
    public ReturnY FI010(@RequestBody RqHttpRebate rebate) {
        ReturnY ReturnY = null;
        if (rebate.getHead() != null) {
            ReturnY = HttpUtil.sendDatas("FI010", rebate, 2);
        }
        return ReturnY == null ? new ReturnY(ReturnY.FAIL_CODE, "请求参数异常") : ReturnY;
    }

    @ApiOperation(value = "FI011-服务费接口")
    @PostMapping("/FI011")
    public ReturnY FI011(@RequestBody RqHttpServiceCharge serviceCharge) {
        ReturnY ReturnY = null;
        if (serviceCharge.getHead() != null) {
            ReturnY = HttpUtil.sendDatas("FI011", serviceCharge, 2);
        }
        return ReturnY == null ? new ReturnY(ReturnY.FAIL_CODE, "请求参数异常") : ReturnY;
    }

    @ApiOperation(value = "FI029-收款接口")
    @PostMapping("/FI029")
    public ReturnY FI029(@RequestBody JSONObject object) {
        ReturnY ReturnY = null;
        if (!object.isEmpty()) {
            ReturnY = HttpUtil.sendDatas("FI029", object, 2);
        }
        return ReturnY == null ? new ReturnY(ReturnY.FAIL_CODE, "请求参数异常") : ReturnY;
    }

    @ApiOperation(value = "通用接口 auto/ 后面接接口名 例如：auto/FI029  Json 里面使用PoUrl 封装目标路径")
    @PostMapping("/auto/{method}")
    public ReturnY FI029(@PathVariable("method") String method, @RequestBody JSONObject object) {
        ReturnY ReturnY = null;
        if (!object.isEmpty()) {
            ReturnY = HttpUtil.sendDatas(method, object, 2);
        }
        return ReturnY == null ? new ReturnY(ReturnY.FAIL_CODE, "请求参数异常") : ReturnY;
    }
}
