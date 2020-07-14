package com.yuoumall.push.center.entity.bo.common;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description 
 */
@Data
@Table(name = "SYNC_SAP_SALE_DETAIL")
public class SyncSapSaleDetail {
    /**
     * 单据号
     */
    @Column(name = "BILLNO")
    private String billno;

    /**
     * 行项目号(进位为10，如第一条为000010)
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
    private BigDecimal kwmeng;

    /**
     * 单位
     */
    @Column(name = "VRKME")
    private String vrkme;

    /**
     * 批次
     */
    @Column(name = "CHARG")
    private String charg;

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
     * 储存地点
     */
    @Column(name = "LGORT")
    private String lgort;

    /**
     * 物料科目分配组
     */
    @Column(name = "KTGRM")
    private String ktgrm;

    /**
     * 税分类
     */
    @Column(name = "TAXM1")
    private String taxm1;

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
     * 平台客户编号
     */
    @Column(name = "ZZPLATF")
    private String zzplatf;

    /**
     * 供应商编号
     */
    @Column(name = "ZZSUPPL")
    private String zzsuppl;

    /**
     * 制单人
     */
    @Column(name = "ZZOR001")
    private String zzor001;

    /**
     * 退货单号
     */
    @Column(name = "ZZOR002")
    private String zzor002;

    /**
     * 订单明细ID
     */
    @Column(name = "ZZORDID")
    private String zzordid;

    /**
     * 销售员
     */
    @Column(name = "PARTNER")
    private String partner;
}