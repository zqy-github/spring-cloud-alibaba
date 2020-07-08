package com.yuoumall.push.center.service.imp;

import com.yuoumall.push.center.entity.bo.SD003.HeadVbak;
import com.yuoumall.push.center.entity.bo.SD003.ItemVbak;
import com.yuoumall.push.center.entity.bo.SD003.PrcdVbak;
import com.yuoumall.push.center.entity.bo.SD003.Vbak;
import com.yuoumall.push.center.entity.bto.SD003.RqHttpVbak;
import com.yuoumall.push.center.entity.bto.SD003.SD003SCREQ;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.yuoumall.push.center.mapper.VbakMapper;
import com.yuoumall.push.center.service.VbakService;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/7
 * @Version 1.0
 * @Description
 */
@Service
public class VbakServiceImpl implements VbakService {

    @Resource
    private VbakMapper vbakMapper;

    @Override
    public List<SD003SCREQ> selectFormatVbakByStatusNo() {
        List<Vbak> vbakList = vbakMapper.selectFormatVbakByStatusNo();
        List<SD003SCREQ> returnList = null;
        if (vbakList.size() > 0) {
            vbakList.forEach(item -> {
                RqHttpVbak vbak = new RqHttpVbak();

                HeadVbak headVbak = new HeadVbak();
                BeanUtils.copyProperties(item, headVbak);
                vbak.setHead(headVbak);

                List<ItemVbak> itemVbakList = null;
                ItemVbak itemvbak = new ItemVbak();
                BeanUtils.copyProperties(item, itemvbak);
                itemVbakList.add(itemvbak);
                vbak.setItem(itemVbakList);

                List<PrcdVbak> prcdVbakList = null;
                PrcdVbak prcdVbak = new PrcdVbak();
                BeanUtils.copyProperties(item, prcdVbak);
                prcdVbakList.add(prcdVbak);
                vbak.setPrcd(prcdVbakList);

                SD003SCREQ screq = new SD003SCREQ();
                screq.setDT_SD003_SC_REQ(vbak);

                returnList.add(screq);
            });
        }
        return returnList;
    }
}
