package com.horn.edu.sso.server.model;

import com.horn.edu.sso.mybatis.model.PersistentObject;

/**
 * 用户角色映射
 *
 * Created by misterxu on 2018/11/6.
 */
public class UserRole extends PersistentObject {
    private static final long serialVersionUID = 4942358338145288018L;

    /** 用户ID */
    private Integer userId;
    /** 角色ID */
    private Integer roleId;

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
