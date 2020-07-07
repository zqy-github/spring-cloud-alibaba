package com.yuoumall.push.center.entity.bto.SD001;

import com.yuoumall.push.center.entity.bo.SD001.HeadMara;
import com.yuoumall.push.center.entity.bo.SD001.ItemMara;
import com.yuoumall.push.center.entity.bo.SD001.PrcdMara;
import lombok.Data;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
@Data
public class RqHttpMara {
    private HeadMara HEAD;
    private ItemMara ITEM;
    private PrcdMara PRCD;
}
