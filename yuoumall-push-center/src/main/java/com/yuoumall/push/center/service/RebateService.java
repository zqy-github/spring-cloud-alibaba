package com.yuoumall.push.center.service;

import com.yuoumall.push.center.entity.bto.FI010.FI010SCREQ;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
public interface RebateService {
    /**
     * 查询未请求数据
     * @return
     */
    List<FI010SCREQ> selectFormatRebateByStatusNo();

    /**
     * 修改数据为已请求
     * @param id
     */
    void updateRebateStatusYes(Long id);
}
