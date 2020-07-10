package com.yuoumall.push.center.service.imp;

import com.yuoumall.push.center.entity.bo.SD002.*;
import com.yuoumall.push.center.entity.bto.SD002.RqHttpVbap;
import com.yuoumall.push.center.entity.bto.SD002.SD002SCREQ;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.yuoumall.push.center.mapper.VbapMapper;
import com.yuoumall.push.center.service.VbapService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
@Service
public class VbapServiceImpl implements VbapService {

    @Resource
    private VbapMapper vbapMapper;

    @Override
    public HttpVbap selectFormatVbapByPrimaryKey(int i) {
        Vbap vbap = vbapMapper.selectByPrimaryKey(i);
        HttpVbap httpVbap = new HttpVbap();
        if (vbap != null) {
            HeadVbap headVbap = new HeadVbap();
            BeanUtils.copyProperties(vbap, headVbap);
            httpVbap.setHEAD(headVbap);

            ItemVbap itemVbap = new ItemVbap();
            BeanUtils.copyProperties(vbap, itemVbap);
            httpVbap.setITEM(itemVbap);

            PrcdVabp prcdVabp = new PrcdVabp();
            BeanUtils.copyProperties(vbap, prcdVabp);
            httpVbap.setPRCD(prcdVabp);

            BplnVabp bplnVabp = new BplnVabp();
            BeanUtils.copyProperties(vbap, bplnVabp);
            httpVbap.setBPLN(bplnVabp);
        }
        return httpVbap;
    }

    @Override
    public List<SD002SCREQ> selectFormatVbapByStatusNo() {
        List<Vbap> vbapList = vbapMapper.selectFormatVbapByStatusNo();
        List<SD002SCREQ> returnList = new ArrayList<>();
        if (vbapList.size() > 0) {
            vbapList.forEach(item -> {
                RqHttpVbap vbap = new RqHttpVbap();

                HeadVbap headVbap = new HeadVbap();
                BeanUtils.copyProperties(item, headVbap);
                vbap.setHead(headVbap);

                List<ItemVbap> itemVbapList = new ArrayList<>();
                ItemVbap itemVbap = new ItemVbap();
                BeanUtils.copyProperties(item, itemVbap);
                itemVbapList.add(itemVbap);
                vbap.setItem(itemVbapList);

                List<BplnVabp> bplnVabpList = new ArrayList<>();
                BplnVabp bplnVabp = new BplnVabp();
                BeanUtils.copyProperties(item, bplnVabp);
                bplnVabpList.add(bplnVabp);
                vbap.setBpln(bplnVabpList);

                List<PrcdVabp> prcdVabpList = new ArrayList<>();
                PrcdVabp prcdVabp = new PrcdVabp();
                BeanUtils.copyProperties(item, prcdVabp);
                prcdVabpList.add(prcdVabp);
                vbap.setPrcd(prcdVabpList);

                SD002SCREQ screq = new SD002SCREQ();
                screq.setDT_SD002_SC_REQ(vbap);

                returnList.add(screq);
            });
        }
        return returnList;
    }

    @Override
    public void updateVbapStatusYes(Long id) {
        vbapMapper.updateVbapStatusYes(id);
    }
}