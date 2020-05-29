package com.zqy.commons.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zqy.commons.dto.AbstractBaseDomain;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用的响应结果
 * <p>Title: AbstractBaseResult</p>
 * <p>Description: </p>
 *
 * @Author: ZQY
 * @Date: 2020/5/28 15:06
 * @Version: 1.0
 *
 */
@Data
public abstract class AbstractBaseResult implements Serializable {

    /**
     * 此为内部类
     */
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected static class Links {
        private String self;
        private String next;
        private String last;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected static class DataBean<T extends AbstractBaseDomain> {
        private String type;
        private Long id;
        private T attributes;
        private T relationships;
        private Links links;
    }
}