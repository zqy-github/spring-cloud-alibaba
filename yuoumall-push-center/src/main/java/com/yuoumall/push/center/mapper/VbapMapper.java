package com.yuoumall.push.center.mapper;

import com.yuoumall.push.center.entity.bo.SD002.Vbap;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description 
 */
@org.apache.ibatis.annotations.Mapper
public interface VbapMapper extends Mapper<Vbap> {
    List<Vbap> selectFormatVbapByStatusNo();

    void updateVbapStatusYes(Long id);
}