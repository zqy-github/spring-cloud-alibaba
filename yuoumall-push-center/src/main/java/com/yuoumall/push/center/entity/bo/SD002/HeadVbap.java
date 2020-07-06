package com.yuoumall.push.center.entity.bo.SD002;

import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */

@Data
public class HeadVbap {
    /**
     * 订单类型
     */
    private String auart;

    /**
     * 销售组织
     */
    private String vkorg;

    /**
     * 分销渠道
     */
    private String vtweg;

    /**
     * 产品组
     */
    private String spart;

    /**
     * 销售办公室
     */
    private String vkbur;

    /**
     * 销售组
     */
    private String vkgrp;

    /**
     * 客户
     */
    private String kunnr;

    /**
     * 客户参考
     */
    private String bstkd;

    /**
     * 客户参考日期
     */
    private String bstdk;

    /**
     * 请求交货日期
     */
    private String vdatu;

    /**
     * 凭证货币
     */
    private String waerk;

    /**
     * 开始日期
     */
    private String bedat;

    /**
     * 订单文本
     */
    private String ltext;

}
