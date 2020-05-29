package com.zqy.commons.service;

import com.zqy.commons.dto.AbstractBaseDomain;

/**
 * 通用的业务逻辑
 * <p>Title: BaseCrudService</p>
 * <p>Description: </p>
 *
 * @Author: ZQY
 * @Date: 2020/5/28 15:30
 * @Version: 1.0
 */
public interface BaseCrudService<T extends AbstractBaseDomain> {

    /**
     * 查询属性值是否唯一
     *
     * @param property
     * @param value
     * @return true/唯一，false/不唯一
     */
    default boolean unique(String property, String value) {
        return false;
    }

    /**
     * 保存
     * @param domain
     * @return
     */
    default T save(T domain) {
        return null;
    }
}
