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
@Table(name = "SYNC_SAP_QUEUE")
public class SyncSapQueue {
    /**
     * 接口类型
     */
    @Column(name = "IFC_TYPE")
    private String ifcType;

    /**
     * 传输值
     */
    @Column(name = "TRANS_KEY")
    private String transKey;

    /**
     * 创建日期
     */
    @Column(name = "CRT_DATE")
    private Date crtDate;

    /**
     * 最后更新日期
     */
    @Column(name = "UPT_DATE")
    private Date uptDate;

    /**
     * 失败次数
     */
    @Column(name = "FAIL_COUNT")
    private BigDecimal failCount;
}