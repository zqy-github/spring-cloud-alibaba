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
@Table(name = "SYNC_SAP_CONFIG_MAIN")
public class SyncSapConfigMain {
    /**
     * 接口类型
     */
    @Id
    @Column(name = "IFC_TYPE")
    private String ifcType;

    /**
     * 接口名称
     */
    @Column(name = "IFC_NAME")
    private String ifcName;

    /**
     * 接口重试次数
     */
    @Column(name = "RETRY_COUNT")
    private Integer retryCount;

    /**
     * 重试间隔(单位:秒)
     */
    @Column(name = "RETRY_INTERVAL")
    private BigDecimal retryInterval;

    /**
     * 序号(传输顺序)
     */
    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    /**
     * 是否停用(0-否,1-是)
     */
    @Column(name = "FLAG_STOP")
    private Integer flagStop;

    /**
     * 创建日期
     */
    @Column(name = "CRT_DATE")
    private Date crtDate;

    /**
     * 传输地址
     */
    @Column(name = "SEND_ADDR")
    private String sendAddr;

    /**
     * 每次请求条数
     */
    @Column(name = "REQUEST_LIMIT")
    private Integer requestLimit;
}