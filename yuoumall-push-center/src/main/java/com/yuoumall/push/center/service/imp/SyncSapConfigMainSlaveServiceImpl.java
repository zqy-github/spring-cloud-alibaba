package com.yuoumall.push.center.service.imp;

import com.yuoumall.push.center.entity.bo.common.SyncSapConfigMainSlave;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yuoumall.push.center.mapper.SyncSapConfigMainSlaveMapper;
import com.yuoumall.push.center.service.SyncSapConfigMainSlaveService;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description 
 */
@Service
public class SyncSapConfigMainSlaveServiceImpl implements SyncSapConfigMainSlaveService{

    @Resource
    private SyncSapConfigMainSlaveMapper syncSapConfigMainSlaveMapper;

    @Override
    public List<SyncSapConfigMainSlave> selectFormatDataByIfcType(String ifcType) {
        return syncSapConfigMainSlaveMapper.selectFormatDataByIfcType(ifcType);
    }
}
