package com.yuoumall.push.center.service.imp;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yuoumall.push.center.mapper.SyncSapTabMappingMapper;
import com.yuoumall.push.center.service.SyncSapTabMappingService;
/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description 
 */
@Service
public class SyncSapTabMappingServiceImpl implements SyncSapTabMappingService{

    @Resource
    private SyncSapTabMappingMapper syncSapTabMappingMapper;

}
