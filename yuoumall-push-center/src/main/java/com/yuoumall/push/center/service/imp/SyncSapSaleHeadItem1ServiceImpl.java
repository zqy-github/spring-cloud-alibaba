package com.yuoumall.push.center.service.imp;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yuoumall.push.center.mapper.SyncSapSaleHeadItem1Mapper;
import com.yuoumall.push.center.service.SyncSapSaleHeadItem1Service;
/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description 
 */
@Service
public class SyncSapSaleHeadItem1ServiceImpl implements SyncSapSaleHeadItem1Service{

    @Resource
    private SyncSapSaleHeadItem1Mapper syncSapSaleHeadItem1Mapper;

}
