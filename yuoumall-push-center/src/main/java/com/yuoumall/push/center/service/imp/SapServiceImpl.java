package com.yuoumall.push.center.service.imp;

import com.yuoumall.push.center.entity.bo.common.Status;
import com.yuoumall.push.center.entity.bo.common.SyncSapConfigMain;
import com.yuoumall.push.center.entity.bo.common.SyncSapConfigMainSlave;
import com.yuoumall.push.center.entity.bo.common.SyncSapQueue;
import com.yuoumall.push.center.mapper.SyncSapConfigMainMapper;
import com.yuoumall.push.center.mapper.SyncSapConfigMainSlaveMapper;
import com.yuoumall.push.center.service.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
@Service
public class SapServiceImpl implements SapService {

    @Resource
    private SyncSapQueueService queueService;

    @Autowired
    private SyncSapConfigMainMapper configMapper;

    @Autowired
    private SyncSapConfigMainSlaveMapper configSlaveMapper;

    @Autowired
    private SyncSapTransferLogService logService;


    @Override
    public List<JSONObject> selectFormatDataByMethodStatusNo(String method) {
        // 获取接口配置信息 order条件， limit 条件
        Example example = new Example(SyncSapConfigMain.class);
        example.createCriteria().andEqualTo("ifcType", method);
        SyncSapConfigMain configMain = configMapper.selectOneByExample(example);

        // 获取接口配置信息 sql语句 数据表头：HEAD ITEM....
        Example examples = new Example(SyncSapConfigMainSlave.class);
        examples.createCriteria().andEqualTo("ifcType", method);
        examples.setOrderByClause("ORDER_NUM ASC");
        List<SyncSapConfigMainSlave> configs = configSlaveMapper.selectByExample(examples);

        // 获取请求队列 里面包含 where条件的对应值
        List<SyncSapQueue> queues = queueService.selectFormatDataByMethodAndFailCount(method, configMain.getRetryCount(), configMain.getRequestLimit());

        List<JSONObject> returnList = new ArrayList<>();
        // 封装数据
        if (queues.size() > 0) {
            queues.forEach(queue -> {
                JSONObject object = new JSONObject();
                if (configs.size() > 0) {
                    configs.forEach(config -> {
                        // 获取查询sql
                        String sql = config.getSourceSql().replaceAll("\n", "");
                        // 获取查询条件值
                        String transKey = queue.getTransKey();
                        String[] keyList = transKey.split(",");
                        // 封装查询sql
                        for (int i = 0; i < keyList.length; i++) {
                            String oldChar = "$" + (i + 1);
                            sql = sql.replace(oldChar,  keyList[i]);
                        }
                        // 获取数据 封装json
                        if (config.getSecType().equalsIgnoreCase("HEAD")) {
                            JSONObject queryObject = queueService.selectDataMapBySql(sql);
                            object.put("HEAD", queryObject);

                        } else {
                            try {
                                JSONArray queryObject = queueService.selectDataListBySql(sql);
                                object.put(config.getSecType(), queryObject);
                            }catch (Exception e){
                                JSONObject queryObject  = queueService.selectDataMapBySql(sql);
                                object.put(config.getSecType(), queryObject);
                            }
                        }
                    });
                }
                // 封装返回数据
                returnList.add(object);
            });
        }
        return returnList;
    }

    @Override
    public void updateStatusSuccess(String ifcType, String transKey, String rtmsg, String rtcod) {
        queueService.deleteByTypeAndKey(ifcType, transKey);
        logService.addLog(ifcType, transKey, rtmsg, rtcod);
    }

    @Override
    public void insertLostNum(String ifcType, String transKey, String rtmsg, String rtcode) {
        queueService.addLostNum(ifcType, transKey);
        logService.addLog(ifcType, transKey, rtmsg, rtcode);
    }

    @Override
    public void insertLostNum(Status status) {

    }
}
