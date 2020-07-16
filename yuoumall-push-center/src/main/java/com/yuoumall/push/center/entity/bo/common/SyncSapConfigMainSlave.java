package com.yuoumall.push.center.entity.bo.common;

import java.math.BigDecimal;
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
@Table(name = "SYNC_SAP_CONFIG_MAIN_SLAVE")
public class SyncSapConfigMainSlave {
    /**
     * 接口类型
     */
    @Column(name = "IFC_TYPE")
    private String ifcType;

    /**
     * 报文所属块
     */
    @Column(name = "SEC_TYPE")
    private String secType;

    /**
     * 数据来源表名
     */
    @Column(name = "TAB_NAME")
    private String tabName;

    /**
     * 是否停用(0-否,1-是)
     */
    @Column(name = "FLAG_STOP")
    private BigDecimal flagStop;

    /**
     * 数据源sql
     */
    @Column(name = "SOURCE_SQL")
    private String sourceSql;

    /**
     * 创建日期
     */
    @Column(name = "CRT_DATE")
    private Date crtDate;

    /**
     *  排序
     */
    @Column(name = "ORDER_NUM")
    private Integer orderNum;
}