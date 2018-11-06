package com.horn.edu.sso.server.service;

import com.horn.edu.sso.mybatis.model.Pagination;
import com.horn.edu.sso.mybatis.service.Service;
import com.horn.edu.sso.server.model.Role;

import java.util.List;

/**
 * 角色服务接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface RoleService extends Service<Role, Integer> {
    /**
     * 启用禁用操作
     * @param isEnable 是否启用
     * @param idList 角色ID集合
     * @return
     */
    public void enable(Boolean isEnable, List<Integer> idList);

    /**
     * 根据角色名称和应用ID查询分页列表
     * @param name 角色名称
     * @param p 分页参数
     * @return
     */
    public Pagination<Role> findPaginationByName(String name, Pagination<Role> p);

    /**
     * 查询应用可用角色
     * @param isEnable 是否启用
     * @return
     */
    public List<Role> findByAll(Boolean isEnable);
}
