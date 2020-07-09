package com.yuoumall.push.center.mapper;

import com.yuoumall.push.center.entity.bo.SD001.Mara;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description 
 */
@org.apache.ibatis.annotations.Mapper
public interface MaraMapper extends Mapper<Mara> {
    List<Mara> selectFormatMaraByStatusNo();

    void updateMaraStatusYes(Long id);
}