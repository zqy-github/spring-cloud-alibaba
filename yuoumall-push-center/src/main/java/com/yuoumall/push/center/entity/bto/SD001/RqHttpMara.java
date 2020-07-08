package com.yuoumall.push.center.entity.bto.SD001;

import com.yuoumall.push.center.entity.bo.SD001.HeadMara;
import com.yuoumall.push.center.entity.bo.SD001.ItemMara;
import com.yuoumall.push.center.entity.bo.SD001.PrcdMara;
import lombok.Data;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
@Data
public class RqHttpMara {
    private HeadMara head;
    private List<ItemMara> item;
    private List<PrcdMara> prcd;
}
