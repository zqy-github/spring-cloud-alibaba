package com.yuoumall.push.center.service.imp;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yuoumall.push.center.mapper.SyncSapSaleDetailItem1Mapper;
import com.yuoumall.push.center.service.SyncSapSaleDetailItem1Service;
/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description 
 */
@Service
public class SyncSapSaleDetailItem1ServiceImpl implements SyncSapSaleDetailItem1Service{

    @Resource
    private SyncSapSaleDetailItem1Mapper syncSapSaleDetailItem1Mapper;

}
