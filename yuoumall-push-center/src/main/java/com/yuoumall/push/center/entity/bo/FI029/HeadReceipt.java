package com.yuoumall.push.center.entity.bo.FI029;

import lombok.Data;


/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
@Data
public class HeadReceipt {

    private Integer id;

    /**
     * 业务分类
     */
    private String bucls;

    /**
     * 业务类型
     */
    private String butyp;

    /**
     * 参考单据号
     */
    private String refno;

    /**
     * 公司代码
     */
    private String bukrs;

    /**
     * 会计年度
     */
    private String gjahr;

    /**
     * 凭证日期
     */
    private String bldat;

    /**
     * 过账日期
     */
    private String budat;

    /**
     * 货币码
     */
    private String waers;

    /**
     * 抬头文本
     */
    private String bktxt;

    /**
     * 会计凭证号码
     */
    private String belnr;

    /**
     * 冲销标识
     */
    private String xstov;

    /**
     * 冲销原因
     */
    private String stgrd;

    /**
     * 操作人姓名
     */
    private String opnam;
}
