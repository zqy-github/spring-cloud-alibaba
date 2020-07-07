package com.yuoumall.push.center.service;

import com.yuoumall.push.center.entity.bo.SD001.HttpMara;
import com.yuoumall.push.center.entity.bo.SD001.Mara;
import com.yuoumall.push.center.entity.bto.SD001.SD001SCREQ;

import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
public interface MaraService {

    Mara selectByPrimaryKey(int i);

    HttpMara selectFormatMaraByPrimaryKey(int i);

    /**
     * 获取未请求的数据
     * @return
     */
    List<SD001SCREQ> selectFormatMaraByStatusNo();
}
