package com.yuoumall.push.center.entity.bo.common;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description
 */
@Data
@Table(name = "REBATE")
public class Status {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "BUCLS")
    private String bucls;

    /**
     * 失败次数
     */
    @Column(name = "BUTYP")
    private String butyp;

    /**
     * 备注信息
     */
    @Column(name = "REFNO")
    private String refno;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;
}
