package com.horn.edu.sso.server.service;

import com.horn.edu.sso.mybatis.service.Service;
import com.horn.edu.sso.server.model.RolePermission;

import java.util.List;

/**
 * 角色权限映射服务接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface RolePermissionService extends Service<RolePermission, Integer> {
    /**
     * 根据角色ID查询映射
     * @param roleId 角色ID
     * @return
     */
    public List<RolePermission> findByRoleId(Integer roleId);

    /**
     * 根据角色ID给角色授权
     * @param appId 应用ID
     * @param roleId 角色ID
     * @param permissionIdList 权限ID集合
     * @return
     */
    public void allocate(Integer appId, Integer roleId, List<Integer> permissionIdList);

    /**
     * 根据权限ID集合删除映射
     * @param idList 权限ID集合
     * @return
     */
    public void deleteByPermissionIds(List<Integer> idList);

    /**
     * 根据角色ID集合删除映射
     * @param idList 角色ID集合
     * @return
     */
    public void deleteByRoleIds(List<Integer> idList);

    /**
     * 根据应用ID集合删除映射
     * @param idList 应用ID集合
     * @return
     */
    public void deleteByAppIds(List<Integer> idList);
}
