package com.yuoumall.push.center.mapper;

import com.yuoumall.push.center.entity.bo.FI029.Receipt;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
@org.apache.ibatis.annotations.Mapper
public interface ReceiptMapper extends Mapper<Receipt> {
    List<Receipt> selectFormatReceiptByStatusNo();

    void updateReceiptStatusYes(Long id);
}