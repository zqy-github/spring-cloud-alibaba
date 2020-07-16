package com.transfer.center.controller;

import com.transfer.center.util.HttpUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ZQY
 * @Date 2020/7/16
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/transfer")
public class TransferCenterController {
    @PostMapping("/init")
    public String init(@RequestParam(value = "logistics_interface") String object) {
        String aReturn = "无结果";
        if (!object.isEmpty()) {
            aReturn = HttpUtil.sendDatas(object);
        }
        return aReturn;
    }
}
