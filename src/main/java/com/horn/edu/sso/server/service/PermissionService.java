package com.horn.edu.sso.server.service;

import com.horn.edu.sso.mybatis.service.Service;
import com.horn.edu.sso.server.model.Permission;
import com.horn.edu.sso.server.rpc.RpcPermission;

import java.util.List;

/**
 * 权限服务接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface PermissionService extends Service<Permission, Integer> {
    /**
     * 根据名称和应用ID查询
     * @param appId 应用ID
     * @param roleId 角色ID
     * @param isEnable
     * @return
     */
    public List<Permission> findByAppId(Integer appId, Integer roleId, Boolean isEnable);

    /**
     * 删除权限
     * @param id 权限ID
     * @param appId 应用ID
     * @return
     */
    public void deletePermission(Integer id, Integer appId);

    /**
     * 删除应用下所有权限
     * @param idList 应用ID集合
     * @return
     */
    public void deleteByAppIds(List<Integer> idList);

    /**
     * 根据应用编码和用户ID查权限
     * @param appCode 应用编码
     * @param userId 用户ID
     * @return
     */
    public List<RpcPermission> findListById(String appCode, Integer userId);
}
