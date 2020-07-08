package com.yuoumall.push.center.entity.bto.SD002;

import com.yuoumall.push.center.entity.bo.SD002.BplnVabp;
import com.yuoumall.push.center.entity.bo.SD002.HeadVbap;
import com.yuoumall.push.center.entity.bo.SD002.ItemVbap;
import com.yuoumall.push.center.entity.bo.SD002.PrcdVabp;
import lombok.Data;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
@Data
public class RqHttpVbap {
    private HeadVbap head;
    private List<ItemVbap> item;
    private List<PrcdVabp> prcd;
    private List<BplnVabp> bpln;
}
