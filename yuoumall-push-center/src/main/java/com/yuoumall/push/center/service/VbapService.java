package com.yuoumall.push.center.service;

import com.yuoumall.push.center.entity.bo.SD002.HttpVbap;

/**
 * @Author ZQY
 * @Date 2020/7/3
 * @Version 1.0
 * @Description
 */
public interface VbapService {
    HttpVbap selectFormatVbapByPrimaryKey(int i);
}