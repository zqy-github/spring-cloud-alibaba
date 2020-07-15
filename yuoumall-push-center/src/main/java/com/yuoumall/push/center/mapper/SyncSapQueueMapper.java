package com.yuoumall.push.center.mapper;

import com.yuoumall.push.center.entity.bo.common.SyncSapQueue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description
 */
@org.apache.ibatis.annotations.Mapper
public interface SyncSapQueueMapper extends Mapper<SyncSapQueue> {
    List<SyncSapQueue> selectFormatDataByMethodAndFailCount(@Param("method") String method, @Param("retryCount") Integer retryCount, @Param("requestLimit") Integer requestLimit);

    void deleteByTypeAndKey(@Param("ifcType") String ifcType, @Param("transKey") String transKey);

    void addLostNum(@Param("ifcType") String ifcType, @Param("transKey") String transKey);

    Map selectDataMapBySql(@Param("sql") String sql);

    List<Map<String, Object>> selectDataListBySql(@Param("sql") String sql);
}