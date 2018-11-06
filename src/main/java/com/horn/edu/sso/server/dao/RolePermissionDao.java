package com.horn.edu.sso.server.dao;

import com.horn.edu.sso.mybatis.dao.mybatis.Dao;
import com.horn.edu.sso.server.model.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色权限映射持久化接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface RolePermissionDao extends Dao<RolePermission, Integer> {

    public List<RolePermission> findByRoleId(@Param("roleId") Integer roleId);

    public int deleteByPermissionIds(@Param("idList") List<Integer> idList);

    public int deleteByRoleIds(@Param("idList") List<Integer> idList);

    public int deleteByAppIds(@Param("idList") List<Integer> idList);

    public int deleteByAppAndRoleId(@Param("appId") Integer appId, @Param("roleId") Integer roleId);
}
