package com.yuoumall.push.center.service.imp;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yuoumall.push.center.mapper.SyncSapSaleDetailMapper;
import com.yuoumall.push.center.service.SyncSapSaleDetailService;
/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description 
 */
@Service
public class SyncSapSaleDetailServiceImpl implements SyncSapSaleDetailService{

    @Resource
    private SyncSapSaleDetailMapper syncSapSaleDetailMapper;

}
