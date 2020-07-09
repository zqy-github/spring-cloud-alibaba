package com.yuoumall.push.center.service;

import com.yuoumall.push.center.entity.bto.SD003.SD003SCREQ;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/7
 * @Version 1.0
 * @Description 
 */
public interface VbakService{

    /**
     * 获取未请求的数据
     * @return
     */
    List<SD003SCREQ> selectFormatVbakByStatusNo();

    /**
     * 更新状态为1
     * @param id
     */
    void updateVbaStatusYes(Long id);
}
