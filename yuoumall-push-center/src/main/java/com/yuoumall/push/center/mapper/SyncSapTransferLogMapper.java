package com.yuoumall.push.center.mapper;

import com.yuoumall.push.center.entity.bo.common.SyncSapTransferLog;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description
 */
@org.apache.ibatis.annotations.Mapper
public interface SyncSapTransferLogMapper extends Mapper<SyncSapTransferLog> {
    void addLog(@Param("ifcType") String ifcType, @Param("transKey") String transKey, @Param("rtmsg") String rtmsg, @Param("rtcode") String rtcode);
}