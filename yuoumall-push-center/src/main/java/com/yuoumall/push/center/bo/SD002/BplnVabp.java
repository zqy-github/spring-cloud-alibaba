package com.yuoumall.push.center.bo.SD002;

import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */

@Data
public class BplnVabp {
    /**
     * 开票日期
     */
    private String afdat;

    /**
     * 百分比
     */
    private String fproz;

    /**
     * 开票金额
     */
    private String fakwr;
}
