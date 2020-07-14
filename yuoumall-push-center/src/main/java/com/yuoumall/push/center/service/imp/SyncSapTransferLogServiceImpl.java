package com.yuoumall.push.center.service.imp;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yuoumall.push.center.mapper.SyncSapTransferLogMapper;
import com.yuoumall.push.center.service.SyncSapTransferLogService;
/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description 
 */
@Service
public class SyncSapTransferLogServiceImpl implements SyncSapTransferLogService{

    @Resource
    private SyncSapTransferLogMapper syncSapTransferLogMapper;

    @Override
    public void addLog(String ifcType, String transKey, String rtmsg, String rtcode) {
        syncSapTransferLogMapper.addLog(ifcType, transKey, rtmsg, rtcode);
    }
}
