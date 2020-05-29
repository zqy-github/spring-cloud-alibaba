package com.zqy.commons.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 请求失败
 * <p>Title: ErrorResult</p>
 * <p>Description: </p>
 *
 * @Author: ZQY
 * @Date: 2020/5/28 15:05
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
// JSON 不显示为 null 的属性
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResult extends AbstractBaseResult {
    private int code;
    private String title;

    /**
     * 调试信息
     */
    private String detail;
}
