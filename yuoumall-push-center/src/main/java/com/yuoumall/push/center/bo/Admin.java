package com.yuoumall.push.center.bo;

import lombok.Data;

@Data
public class Admin {
    private Integer id;

    /**
    * 状态:0 默认有效 1删除
    */
    private Byte isDisabled;

    /**
    * 权限, 第四位表示能进行用户权限管理，其它三位预留：初始值1，有管理权限15
    */
    private Byte popedom;

    /**
    * 账户id
    */
    private Integer accountId;

    /**
    * 创建时间
    */
    private Integer createdAt;

    /**
    * 修改时间
    */
    private Integer updatedAt;
}