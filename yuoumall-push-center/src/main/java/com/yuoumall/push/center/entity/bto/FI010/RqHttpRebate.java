package com.yuoumall.push.center.entity.bto.FI010;

import com.yuoumall.push.center.entity.bo.FI010.HeadRebate;
import com.yuoumall.push.center.entity.bo.FI010.ItemRebate;
import lombok.Data;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
@Data
public class RqHttpRebate {
    private HeadRebate head;
    private List<ItemRebate> item;
}
