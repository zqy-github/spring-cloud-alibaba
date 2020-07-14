package com.yuoumall.push.center.service;

import com.yuoumall.push.center.entity.bo.common.SyncSapQueue;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description
 */
public interface SyncSapQueueService {
    /**
     * 查询需要请求接口队列
     * @param method 接口名
     * @param retryCount 获取数量
     * @return
     */
    List<SyncSapQueue> selectFormatDataByMethodAndFailCount(String method, Integer retryCount);

    /**
     * 删除请求队列
     * @param ifcType 接口
     * @param transKey 订单号
     */
    void deleteByTypeAndKey(String ifcType, String transKey);

    /**
     * 失败次数加 1
     * @param ifcType 接口
     * @param transKey 订单号
     */
    void addLostNum(String ifcType, String transKey);

    /**
     * 根据sql 查询数据
     * @param sql
     * @return
     */
    JSONObject selectDataMapBySql(String sql);

    /**
     * 根据sql 查询数据
     * @param sql
     * @return
     */
    JSONArray selectDataListBySql(String sql);
}
