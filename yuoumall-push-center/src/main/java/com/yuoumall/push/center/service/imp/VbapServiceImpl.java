package com.yuoumall.push.center.service.imp;

import com.yuoumall.push.center.entity.bo.SD002.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.yuoumall.push.center.mapper.VbapMapper;
import com.yuoumall.push.center.service.VbapService;

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
}
