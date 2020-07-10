package com.yuoumall.push.center.mapper;

import com.yuoumall.push.center.entity.bo.FI011.ServiceCharge;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description 
 */
@org.apache.ibatis.annotations.Mapper
public interface ServiceChargeMapper extends Mapper<ServiceCharge> {
    List<ServiceCharge> selectFormatRebateByStatusNo();

    void updateServiceChargeStatusYes(Long id);
}