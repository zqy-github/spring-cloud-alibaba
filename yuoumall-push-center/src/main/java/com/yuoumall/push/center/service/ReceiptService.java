package com.yuoumall.push.center.service;

import com.yuoumall.push.center.entity.bto.FI029.FI029SCREQ;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
public interface ReceiptService {
    /**
     * 获取未请求数据
     * @return
     */
    List<FI029SCREQ> selectFormatReceiptByStatusNo();

    /**
     * 修改数据请求状态为已请求
     * @param id
     */
    void updateReceiptStatusYes(Long id);
}
