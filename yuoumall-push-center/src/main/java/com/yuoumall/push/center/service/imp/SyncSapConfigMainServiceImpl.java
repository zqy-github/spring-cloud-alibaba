package com.yuoumall.push.center.service.imp;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yuoumall.push.center.mapper.SyncSapConfigMainMapper;
import com.yuoumall.push.center.service.SyncSapConfigMainService;
/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description 
 */
@Service
public class SyncSapConfigMainServiceImpl implements SyncSapConfigMainService{

    @Resource
    private SyncSapConfigMainMapper syncSapConfigMainMapper;

}
