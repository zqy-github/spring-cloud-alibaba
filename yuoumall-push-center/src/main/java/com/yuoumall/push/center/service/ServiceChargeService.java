package com.yuoumall.push.center.service;

import com.yuoumall.push.center.entity.bto.FI011.FI011SCREQ;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
public interface ServiceChargeService {
    /**
     * 获取未请求数据
     * @return
     */
    List<FI011SCREQ> selectFormatServiceChargeByStatusNo();

    /**
     * 修改数据状态为已请求
     * @param id
     */
    void updateServiceChargeStatusYes(Long id);
}
