package com.yuoumall.push.center.entity.bto.FI011;

import com.yuoumall.push.center.entity.bo.FI011.HeadServiceCharge;
import com.yuoumall.push.center.entity.bo.FI011.ItemServiceCharge;
import lombok.Data;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
@Data
public class RqHttpServiceCharge {
    private HeadServiceCharge head;
    private List<ItemServiceCharge> item;
}
