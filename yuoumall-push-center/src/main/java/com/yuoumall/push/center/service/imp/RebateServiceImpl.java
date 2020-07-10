package com.yuoumall.push.center.service.imp;

import com.yuoumall.push.center.entity.bo.FI010.HeadRebate;
import com.yuoumall.push.center.entity.bo.FI010.ItemRebate;
import com.yuoumall.push.center.entity.bo.FI010.Rebate;
import com.yuoumall.push.center.entity.bto.FI010.FI010SCREQ;
import com.yuoumall.push.center.entity.bto.FI010.RqHttpRebate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.yuoumall.push.center.mapper.RebateMapper;
import com.yuoumall.push.center.service.RebateService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description
 */
@Service
public class RebateServiceImpl implements RebateService {

    @Resource
    private RebateMapper rebateMapper;

    @Override
    public List<FI010SCREQ> selectFormatRebateByStatusNo() {
        List<Rebate> rebateList = rebateMapper.selectFormatRebateByStatusNo();
        List<FI010SCREQ> returnList = new ArrayList<>();
        if (rebateList.size() > 0) {
            rebateList.forEach(item -> {
                RqHttpRebate rebate = new RqHttpRebate();

                HeadRebate headRebate = new HeadRebate();
                BeanUtils.copyProperties(item, headRebate);
                rebate.setHead(headRebate);

                List<ItemRebate> itemRebateList = new ArrayList<>();
                ItemRebate itemRebate = new ItemRebate();
                BeanUtils.copyProperties(item, itemRebate);
                itemRebateList.add(itemRebate);
                rebate.setItem(itemRebateList);

                FI010SCREQ screq = new FI010SCREQ();
                screq.setDT_FI010_SC_REQ(rebate);

                returnList.add(screq);
            });
        }
        return returnList;
    }

    @Override
    public void updateRebateStatusYes(Long id) {
        rebateMapper.updateRebateStatusYes(id);
    }
}
