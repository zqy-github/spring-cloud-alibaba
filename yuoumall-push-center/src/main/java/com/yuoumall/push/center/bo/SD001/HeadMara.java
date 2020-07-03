package com.yuoumall.push.center.bo.SD001;

import lombok.Data;


/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */

@Data
public class HeadMara {
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
     * 汇率
     */
    private String kursk;

    /**
     * 付款条件
     */
    private String zterm;

    /**
     * 订货原因
     */
    private String augru;

    /**
     * 订单文本
     */
    private String ltext;

    /**
     * 名称1
     */
    private String name1;

    /**
     * 名称2
     */
    private String name2;

    /**
     * 国家码
     */
    private String land1;

    /**
     * 地区（省/自治区/直辖市、市、县）
     */
    private String regio;

    /**
     * 城市
     */
    private String city1;

    /**
     * 街道
     */
    private String street;
}
