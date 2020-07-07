package com.yuoumall.push.center.entity.bto.SD003;

import com.yuoumall.push.center.entity.bo.SD003.HeadVbak;
import com.yuoumall.push.center.entity.bo.SD003.ItemVbak;
import com.yuoumall.push.center.entity.bo.SD003.PrcdVbak;
import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
@Data
public class RqHttpVbak {
    private HeadVbak HEAD;
    private ItemVbak ITEM;
    private PrcdVbak PRCD;
}
