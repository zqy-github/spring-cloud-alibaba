package com.yuoumall.push.center.bo.SD002;

import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */

@Data
public class ItemVbap {
    /**
     * 行项目号
     */
    private String posnr;

    /**
     * 物料编码
     */
    private String matnr;

    /**
     * 订单数量
     */
    private String kwmeng;

    /**
     * 单位
     */
    private String vrkme;

    /**
     * 利润中心
     */
    private String prctr;

    /**
     * 工厂
     */
    private String werks;

    /**
     * 物料科目分配组
     */
    private String ktgrm;

    /**
     * 原订单号
     */
    private String zzordno;

    /**
     * 门店客户编号
     */
    private String zzstore;

    /**
     * 区服编号
     */
    private String zzservi;

    /**
     * 预留字段1
     */
    private String zzor001;

    /**
     * 预留字段2
     */
    private String zzor002;

    /**
     * 销售员
     */
    private String partner;
}
