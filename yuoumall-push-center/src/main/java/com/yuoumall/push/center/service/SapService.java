package com.yuoumall.push.center.service;

import com.yuoumall.push.center.entity.bo.common.Status;
import com.yuoumall.push.center.entity.bto.SD001.RqHttpMara;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
public interface SapService {

    /**
     * 更新状态为
     * @param ifcType
     * @param transKey
     * @param rtcode
     */
    void updateStatusSuccess(String ifcType, String transKey, String rtcode);

    /**
     * 记录失败次数和失败信息
     * @param ifcType
     * @param transKey
     * @param rtmsg
     * @param rtcode
     */
    void insertLostNum(String ifcType, String transKey, String rtmsg, String rtcode);

    /**
     * 添加失败状态记录
     * @param status
     */
    void insertLostNum(Status status);

    /**
     * 根据接口
     * @return
     */
    List<JSONObject> selectFormatDataByMethodStatusNo(String method);
}
