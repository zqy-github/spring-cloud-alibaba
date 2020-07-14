package com.yuoumall.push.center.service;

/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description
 */
public interface SyncSapTransferLogService {
    /**
     * 添加请求日志
     * @param ifcType
     * @param transKey
     * @param rtmsg
     * @param rtcode
     */
    void addLog(String ifcType, String transKey, String rtmsg, String rtcode);
}
