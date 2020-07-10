package com.yuoumall.push.center.entity.bo.FI010;

import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
@Data
public class ItemRebate {
    /**
     * 行项目
     */
    private String buitm;

    /**
     * 客户编号
     */
    private String kunnr;

    /**
     * 供应商(自定义)
     */
    private String zzlifnr;

    /**
     * 合同号
     */
    private String zzconno;

    /**
     * 利润中心
     */
    private String prctr;

    /**
     * 物料
     */
    private String matnr;

    /**
     * 税码
     */
    private String mwskz;

    /**
     * 交易货币金额
     */
    private String wrbtr;
}
