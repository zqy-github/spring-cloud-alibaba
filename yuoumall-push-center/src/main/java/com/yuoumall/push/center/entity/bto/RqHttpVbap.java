package com.yuoumall.push.center.entity.bto;

import com.yuoumall.push.center.entity.bo.SD002.BplnVabp;
import com.yuoumall.push.center.entity.bo.SD002.HeadVbap;
import com.yuoumall.push.center.entity.bo.SD002.ItemVbap;
import com.yuoumall.push.center.entity.bo.SD002.PrcdVabp;
import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
@Data
public class RqHttpVbap {
    private HeadVbap HEAD;
    private ItemVbap ITEM;
    private PrcdVabp PRCD;
    private BplnVabp BPLN;
}
