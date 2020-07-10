package com.yuoumall.push.center.entity.bo.FI011;

import lombok.Data;
/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
@Data
public class ItemServiceCharge {
    /**
     * 行项目
     */
    private String buitm;

    /**
     * 供应商
     */
    private String lifnr;

    /**
     * 合同号
     */
    private String zzconno;

    /**
     * 成本中心
     */
    private String kostl;

    /**
     * 交易货币金额
     */
    private String wrbtr;
}
