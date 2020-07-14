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
@Table(name = "SYNC_SAP_TRANSFER_LOG")
public class SyncSapTransferLog {
    /**
     * 接口类型
     */
    @Column(name = "IFC_TYPE")
    private String ifcType;

    /**
     * 传输值
     */
    @Column(name = "SYNC_KEY")
    private String syncKey;

    /**
     * 传输状态(S-成功,E-失败)
     */
    @Column(name = "SYNC_STATUS")
    private String syncStatus;

    /**
     * 返回的报文
     */
    @Column(name = "RET_MSG")
    private String retMsg;

    /**
     * 创建日期
     */
    @Column(name = "CRT_DATE")
    private Date crtDate;
}