package com.yuoumall.push.center.entity.bo.FI029;

import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
@Data
public class ItemReceipt {
    /**
     * 行项目
     */
    private String buitm;

    /**
     * 客户编号
     */
    private String kunnr;

    /**
     * 合同号
     */
    private String zzconno;

    /**
     * 原因代码
     */
    private String rstgr;

    /**
     * 开户行短代码
     */
    private String hbkid;

    /**
     * 帐户细目的代码
     */
    private String hktid;

    /**
     * 交易货币金额
     */
    private String wrbtr;
}
