package com.yuoumall.push.center.bo.SD002;

import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
@Data
public class HttpVbap {
    private HeadVbap HEAD;
    private ItemVbap ITEM;
    private PrcdVabp PRCD;
    private BplnVabp BPLN;
}
