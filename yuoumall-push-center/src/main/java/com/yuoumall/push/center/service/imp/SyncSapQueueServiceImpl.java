package com.yuoumall.push.center.service.imp;

import com.yuoumall.push.center.entity.bo.common.SyncSapQueue;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.yuoumall.push.center.mapper.SyncSapQueueMapper;
import com.yuoumall.push.center.service.SyncSapQueueService;

import java.util.List;
import java.util.Map;

/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description
 */
@Service
public class SyncSapQueueServiceImpl implements SyncSapQueueService {

    @Resource
    private SyncSapQueueMapper syncSapQueueMapper;

    @Override
    public List<SyncSapQueue> selectFormatDataByMethodAndFailCount(String method, Integer retryCount) {
        return syncSapQueueMapper.selectFormatDataByMethodAndFailCount(method, retryCount);
    }

    @Override
    public void deleteByTypeAndKey(String ifcType, String transKey) {
        syncSapQueueMapper.deleteByTypeAndKey(ifcType, transKey);
    }

    @Override
    public void addLostNum(String ifcType, String transKey) {
        syncSapQueueMapper.addLostNum(ifcType, transKey);
    }

    @Override
    public JSONObject selectDataMapBySql(String sql) {
        Map result = syncSapQueueMapper.selectDataMapBySql(sql);
        return JSONObject.fromObject(result);
    }

    @Override
    public JSONArray selectDataListBySql(String sql) {
        List<Map<String,Object>> result = syncSapQueueMapper.selectDataListBySql(sql);
        return JSONArray.fromObject(result);
    }
}
