package com.yuoumall.push.center.bo;

import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */

@Data
public class PrcdMara {

    /**
     * 行项目号
     */
    private String posnr;

    /**
     * 条件类型
     */
    private String kschl;

    /**
     * 费率（金额或百分比）
     */
    private String kbetr;
}
