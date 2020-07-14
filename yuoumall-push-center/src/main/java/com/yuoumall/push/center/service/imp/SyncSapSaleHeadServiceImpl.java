package com.yuoumall.push.center.service.imp;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yuoumall.push.center.mapper.SyncSapSaleHeadMapper;
import com.yuoumall.push.center.service.SyncSapSaleHeadService;
/**
 * @Author ZQY
 * @Date 2020/7/13
 * @Version 1.0
 * @Description 
 */
@Service
public class SyncSapSaleHeadServiceImpl implements SyncSapSaleHeadService{

    @Resource
    private SyncSapSaleHeadMapper syncSapSaleHeadMapper;

}
