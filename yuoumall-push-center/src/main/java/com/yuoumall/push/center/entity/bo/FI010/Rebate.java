package com.yuoumall.push.center.entity.bo.FI010;

import javax.persistence.*;
import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description 
 */
@Data
@Table(name = "REBATE")
public class Rebate {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 业务分类
     */
    @Column(name = "BUCLS")
    private String bucls;

    /**
     * 业务类型
     */
    @Column(name = "BUTYP")
    private String butyp;

    /**
     * 参考单据号
     */
    @Column(name = "REFNO")
    private String refno;

    /**
     * 公司代码
     */
    @Column(name = "BUKRS")
    private String bukrs;

    /**
     * 会计年度
     */
    @Column(name = "GJAHR")
    private String gjahr;

    /**
     * 凭证日期
     */
    @Column(name = "BLDAT")
    private String bldat;

    /**
     * 过账日期
     */
    @Column(name = "BUDAT")
    private String budat;

    /**
     * 货币码
     */
    @Column(name = "WAERS")
    private String waers;

    /**
     * 抬头文本
     */
    @Column(name = "BKTXT")
    private String bktxt;

    /**
     * 会计凭证号码
     */
    @Column(name = "BELNR")
    private String belnr;

    /**
     * 冲销标识
     */
    @Column(name = "XSTOV")
    private String xstov;

    /**
     * 冲销原因
     */
    @Column(name = "STGRD")
    private String stgrd;

    /**
     * 操作人姓名
     */
    @Column(name = "OPNAM")
    private String opnam;

    /**
     * 行项目 
     */
    @Column(name = "BUITM")
    private String buitm;

    /**
     * 客户编号
     */
    @Column(name = "KUNNR")
    private String kunnr;

    /**
     * 供应商(自定义)
     */
    @Column(name = "ZZLIFNR")
    private String zzlifnr;

    /**
     * 合同号 
     */
    @Column(name = "ZZCONNO")
    private String zzconno;

    /**
     * 利润中心
     */
    @Column(name = "PRCTR")
    private String prctr;

    /**
     * 物料
     */
    @Column(name = "MATNR")
    private String matnr;

    /**
     * 税码
     */
    @Column(name = "MWSKZ")
    private String mwskz;

    /**
     * 交易货币金额
     */
    @Column(name = "WRBTR")
    private String wrbtr;

    /**
     * 请求状态 0 未请求 1 已请求
     */
    @Column(name = "`status`")
    private Byte status;
}