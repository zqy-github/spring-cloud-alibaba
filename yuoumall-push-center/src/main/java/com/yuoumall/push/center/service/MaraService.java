package com.yuoumall.push.center.service;

import com.yuoumall.push.center.entity.bo.SD001.HttpMara;
import com.yuoumall.push.center.entity.bo.SD001.Mara;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
public interface MaraService {

    Mara selectByPrimaryKey(int i);

    HttpMara selectFormatMaraByPrimaryKey(int i);
}
