package com.yuoumall.push.center.mapper;

import com.yuoumall.push.center.entity.bo.SD003.Vbak;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/7
 * @Version 1.0
 * @Description 
 */
@org.apache.ibatis.annotations.Mapper
public interface VbakMapper extends Mapper<Vbak> {
    List<Vbak> selectFormatVbakByStatusNo();

    void updateVbaStatusYes(Long id);
}