package com.yuoumall.push.center.entity.bto.FI029;

import com.yuoumall.push.center.entity.bo.FI029.HeadReceipt;
import com.yuoumall.push.center.entity.bo.FI029.ItemReceipt;
import lombok.Data;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
@Data
public class RqHttpReceipt {
    private HeadReceipt head;
    private List<ItemReceipt> item;
}
