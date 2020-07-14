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
@Table(name = "SYNC_SAP_SALE_HEAD_ITEM1")
public class SyncSapSaleHeadItem1 {
    /**
     * 非业务主键
     */
    @Id
    @Column(name = "ID")
    private BigDecimal id;

    /**
     * 单据号
     */
    @Column(name = "BILLNO")
    private String billno;

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
    private BigDecimal fakwr;
}