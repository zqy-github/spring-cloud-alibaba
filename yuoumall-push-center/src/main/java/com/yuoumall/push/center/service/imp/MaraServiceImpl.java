package com.yuoumall.push.center.service.imp;

import com.yuoumall.push.center.entity.bo.SD001.*;
import com.yuoumall.push.center.entity.bto.SD001.RqHttpMara;
import com.yuoumall.push.center.entity.bto.SD001.SD001SCREQ;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.yuoumall.push.center.mapper.MaraMapper;
import com.yuoumall.push.center.service.MaraService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
@Service
public class MaraServiceImpl implements MaraService {

    @Resource
    private MaraMapper maraMapper;

    @Override
    public Mara selectByPrimaryKey(int i) {

        return maraMapper.selectByPrimaryKey(i);
    }

    @Override
    public HttpMara selectFormatMaraByPrimaryKey(int i) {
        Mara mara = maraMapper.selectByPrimaryKey(i);
        HttpMara httpMara = new HttpMara();
        if (mara != null) {
            HeadMara headMara = new HeadMara();
            BeanUtils.copyProperties(mara, headMara);
            httpMara.setHEAD(headMara);

            ItemMara itemMara = new ItemMara();
            BeanUtils.copyProperties(mara, itemMara);
            httpMara.setITEM(itemMara);

            PrcdMara prcdMara = new PrcdMara();
            BeanUtils.copyProperties(mara, prcdMara);
            httpMara.setPRCD(prcdMara);
        }
        return httpMara;
    }

    @Override
    public List<SD001SCREQ> selectFormatMaraByStatusNo() {
        List<Mara> maraList = maraMapper.selectFormatMaraByStatusNo();
        List<SD001SCREQ> returnList = new ArrayList<>();
        if (maraList.size() > 0) {
            maraList.forEach(item -> {
                RqHttpMara mara = new RqHttpMara();

                HeadMara headMara = new HeadMara();
                BeanUtils.copyProperties(item, headMara);
                mara.setHead(headMara);

                List<ItemMara> itemMaraList = new ArrayList<>();
                ItemMara itemMara = new ItemMara();
                BeanUtils.copyProperties(item, itemMara);
                itemMaraList.add(itemMara);
                mara.setItem(itemMaraList);

                List<PrcdMara> prcdMaraList = new ArrayList<>();
                PrcdMara prcdMara = new PrcdMara();
                BeanUtils.copyProperties(item, prcdMara);
                prcdMaraList.add(prcdMara);
                mara.setPrcd(prcdMaraList);

                SD001SCREQ screq = new SD001SCREQ();
                screq.setDT_SD001_SC_REQ(mara);

                returnList.add(screq);
            });
        }
        return returnList;
    }

    @Override
    public void updateMaraStatusYes(Long id) {
        maraMapper.updateMaraStatusYes(id);
    }
}
