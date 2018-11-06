package com.horn.edu.sso.server.service;

import com.horn.edu.sso.mybatis.service.Service;
import com.horn.edu.sso.server.model.UserRole;

import java.util.List;

/**
 * 用户角色映射服务接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface UserRoleService extends Service<UserRole, Integer> {
    /**
     * 根据用户ID和角色ID查询映射
     * @param userId 用户ID
     * @param roleId 角色ID
     * @return
     */
    public UserRole findByUserRoleId(Integer userId, Integer roleId);

    /**
     * 根据用户ID给用户分配角色
     * @param userId 用户ID
     * @param list 用户角色映射集合
     * @return
     */
    public void allocate(Integer userId, List<UserRole> list);

    /**
     * 根据角色ID集合删除映射
     * @param idList 角色ID集合
     * @return
     */
    public void deleteByRoleIds(List<Integer> idList);

    /**
     * 根据用户ID集合删除映射
     * @param idList 用户ID集合
     * @return
     */
    public void deleteByUserIds(List<Integer> idList);
}
