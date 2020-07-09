package com.yuoumall.push.center.service;

import com.yuoumall.push.center.entity.bo.SD002.HttpVbap;
import com.yuoumall.push.center.entity.bto.SD002.SD002SCREQ;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
public interface VbapService {
    HttpVbap selectFormatVbapByPrimaryKey(int i);


    /**
     * 获取未请求的数据
     * @return
     */
    List<SD002SCREQ> selectFormatVbapByStatusNo();

    /**
     * 更新状态为1
     * @param id
     */
    void updateVbapStatusYes(Long id);
}
