package com.horn.edu.sso.server.dao;

import com.horn.edu.sso.mybatis.dao.mybatis.Dao;
import com.horn.edu.sso.server.model.Permission;
import com.horn.edu.sso.server.rpc.RpcPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限持久化接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface PermissionDao extends Dao<Permission, Integer> {
    public int enable(@Param("isEnable") Boolean isEnable, @Param("idList") List<Integer> idList);

    public int resetPassword(@Param("password") String password, @Param("idList") List<Integer> idList);

    public List<Permission> findByAppId(@Param("appId") Integer appId, @Param("isEnable") Boolean isEnable);

    public int deleteByAppIds(@Param("idList") List<Integer> idList);

    public List<RpcPermission> findListById(@Param("appCode") String appCode, @Param("userId") Integer userId);

}
