package com.horn.edu.sso.server.dao;

import com.horn.edu.sso.mybatis.dao.mybatis.Dao;
import com.horn.edu.sso.server.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色映射持久化接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface UserRoleDao extends Dao<UserRole, Integer> {
    public UserRole findByUserRoleId(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    public int deleteByRoleIds(@Param("idList") List<Integer> idList);

    public int deleteByUserIds(@Param("idList") List<Integer> idList);
}
