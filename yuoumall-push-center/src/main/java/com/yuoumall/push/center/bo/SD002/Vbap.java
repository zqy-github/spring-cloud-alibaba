package com.yuoumall.push.center.bo.SD002;

import javax.persistence.*;
import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description 
 */
@Data
@Table(name = "VBAP")
public class Vbap {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 订单类型
     */
    @Column(name = "AUART")
    private String auart;

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
     * 开始日期
     */
    @Column(name = "BEDAT")
    private String bedat;

    /**
     * 订单文本
     */
    @Column(name = "LTEXT")
    private String ltext;

    /**
     * 行项目号
     */
    @Column(name = "POSNR")
    private String posnr;

    /**
     * 物料编码
     */
    @Column(name = "MATNR")
    private String matnr;

    /**
     * 订单数量
     */
    @Column(name = "KWMENG")
    private String kwmeng;

    /**
     * 单位
     */
    @Column(name = "VRKME")
    private String vrkme;

    /**
     * 利润中心
     */
    @Column(name = "PRCTR")
    private String prctr;

    /**
     * 工厂
     */
    @Column(name = "WERKS")
    private String werks;

    /**
     * 物料科目分配组
     */
    @Column(name = "KTGRM")
    private String ktgrm;

    /**
     * 原订单号
     */
    @Column(name = "ZZORDNO")
    private String zzordno;

    /**
     * 门店客户编号
     */
    @Column(name = "ZZSTORE")
    private String zzstore;

    /**
     * 区服编号
     */
    @Column(name = "ZZSERVI")
    private String zzservi;

    /**
     * 预留字段1
     */
    @Column(name = "ZZOR001")
    private String zzor001;

    /**
     * 预留字段2
     */
    @Column(name = "ZZOR002")
    private String zzor002;

    /**
     * 销售员
     */
    @Column(name = "PARTNER")
    private String partner;

    /**
     * 条件类型
     */
    @Column(name = "KSCHL")
    private String kschl;

    /**
     * 费率（金额或百分比）
     */
    @Column(name = "KBETR")
    private String kbetr;

    /**
     * 开票日期
     */
    @Column(name = "AFDAT")
    private String afdat;

    /**
     * 百分比
     */
    @Column(name = "FPROZ")
    private String fproz;

    /**
     * 开票金额
     */
    @Column(name = "FAKWR")
    private String fakwr;
}