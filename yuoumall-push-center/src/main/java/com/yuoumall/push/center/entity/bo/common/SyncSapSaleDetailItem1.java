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
@Table(name = "SYNC_SAP_SALE_DETAIL_ITEM1")
public class SyncSapSaleDetailItem1 {
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
     * 行项目号(对应ITEM中POSNR值)
     */
    @Column(name = "POSNR")
    private String posnr;

    /**
     * 条件类型
     */
    @Column(name = "KSCHL")
    private String kschl;

    /**
     * 费率（金额或百分比）
     */
    @Column(name = "KBETR")
    private BigDecimal kbetr;
}