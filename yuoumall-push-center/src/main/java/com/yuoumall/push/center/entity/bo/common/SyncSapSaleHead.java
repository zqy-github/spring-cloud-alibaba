package com.yuoumall.push.center.entity.bo.common;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description 
 */
@Data
@Table(name = "SYNC_SAP_SALE_HEAD")
public class SyncSapSaleHead {
    /**
     * 单据号
     */
    @Column(name = "BILLNO")
    private String billno;

    /**
     * 订单类型
     */
    @Column(name = "AUART")
    private String auart;

    /**
     * 单据日期
     */
    @Column(name = "BDATE")
    private Date bdate;

    /**
     * 单据创建日期
     */
    @Column(name = "BCDATE")
    private Date bcdate;

    /**
     * 销售组织
     */
    @Column(name = "VKORG")
    private String vkorg;

    /**
     * 分销渠道
     */
    @Column(name = "VTWEG")
    private String vtweg;

    /**
     * 产品组
     */
    @Column(name = "SPART")
    private String spart;

    /**
     * 销售办公室
     */
    @Column(name = "VKBUR")
    private String vkbur;

    /**
     * 销售组
     */
    @Column(name = "VKGRP")
    private String vkgrp;

    /**
     * 客户
     */
    @Column(name = "KUNNR")
    private String kunnr;

    /**
     * 客户参考
     */
    @Column(name = "BSTKD")
    private String bstkd;

    /**
     * 客户参考日期
     */
    @Column(name = "BSTDK")
    private String bstdk;

    /**
     * 请求交货日期
     */
    @Column(name = "VDATU")
    private String vdatu;

    /**
     * 凭证货币
     */
    @Column(name = "WAERK")
    private String waerk;

    /**
     * 开始日期(服务订单创建接口使用)
     */
    @Column(name = "BEDAT")
    private String bedat;

    /**
     * 汇率
     */
    @Column(name = "KURSK")
    private String kursk;

    /**
     * 付款条件
     */
    @Column(name = "ZTERM")
    private String zterm;

    /**
     * 订货原因
     */
    @Column(name = "AUGRU")
    private String augru;

    /**
     * 订单文本
     */
    @Column(name = "LTEXT")
    private String ltext;

    /**
     * 名称1
     */
    @Column(name = "NAME1")
    private String name1;

    /**
     * 名称2
     */
    @Column(name = "NAME2")
    private String name2;

    /**
     * 国家码(CN 中国)
     */
    @Column(name = "LAND1")
    private String land1;

    /**
     * 地区（省/自治区/直辖市、市、县
     */
    @Column(name = "REGIO")
    private String regio;

    /**
     * 城市
     */
    @Column(name = "CITY1")
    private String city1;

    /**
     * 街道
     */
    @Column(name = "STREET")
    private String street;
}