package com.yuoumall.push.center.service.imp;

import com.yuoumall.push.center.entity.bo.FI011.HeadServiceCharge;
import com.yuoumall.push.center.entity.bo.FI011.ItemServiceCharge;
import com.yuoumall.push.center.entity.bo.FI011.ServiceCharge;
import com.yuoumall.push.center.entity.bto.FI011.FI011SCREQ;
import com.yuoumall.push.center.entity.bto.FI011.RqHttpServiceCharge;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.yuoumall.push.center.mapper.ServiceChargeMapper;
import com.yuoumall.push.center.service.ServiceChargeService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
@Service
public class ServiceChargeServiceImpl implements ServiceChargeService {

    @Resource
    private ServiceChargeMapper ServiceChargeMapper;

    @Override
    public List<FI011SCREQ> selectFormatServiceChargeByStatusNo() {
        List<ServiceCharge> chargeList = ServiceChargeMapper.selectFormatRebateByStatusNo();
        List<FI011SCREQ> returnList = new ArrayList<>();
        if (chargeList.size() > 0) {
            chargeList.forEach(item -> {
                RqHttpServiceCharge serviceCharge = new RqHttpServiceCharge();

                HeadServiceCharge headServiceCharge = new HeadServiceCharge();
                BeanUtils.copyProperties(item, headServiceCharge);
                serviceCharge.setHead(headServiceCharge);

                List<ItemServiceCharge> itemServiceChargeList = new ArrayList<>();
                ItemServiceCharge itemServiceCharge = new ItemServiceCharge();
                BeanUtils.copyProperties(item, item);
                itemServiceChargeList.add(itemServiceCharge);
                serviceCharge.setItem(itemServiceChargeList);

                FI011SCREQ screq = new FI011SCREQ();
                screq.setDT_FI011_SC_REQ(serviceCharge);

                returnList.add(screq);
            });
        }
        return returnList;
    }

    @Override
    public void updateServiceChargeStatusYes(Long id) {
        ServiceChargeMapper.updateServiceChargeStatusYes(id);
    }
}
