package com.yuoumall.push.center.service.imp;

import com.yuoumall.push.center.entity.bo.SD001.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.yuoumall.push.center.mapper.MaraMapper;
import com.yuoumall.push.center.service.MaraService;

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
}
