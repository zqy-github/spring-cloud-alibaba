package com.yuoumall.push.center.mapper;

import com.yuoumall.push.center.entity.bo.common.SyncSapConfigMainSlave;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description 
 */
@org.apache.ibatis.annotations.Mapper
public interface SyncSapConfigMainSlaveMapper extends Mapper<SyncSapConfigMainSlave> {
    List<SyncSapConfigMainSlave> selectFormatDataByIfcType(String ifcType);
}