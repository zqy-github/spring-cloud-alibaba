package com.yuoumall.push.center.service;

import com.yuoumall.push.center.entity.bo.common.SyncSapConfigMainSlave;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description
 */
public interface SyncSapConfigMainSlaveService {
    /**
     * 获取接口需要的数据类型
     * @param ifcType
     * @return
     */
    List<SyncSapConfigMainSlave> selectFormatDataByIfcType(String ifcType);
}
