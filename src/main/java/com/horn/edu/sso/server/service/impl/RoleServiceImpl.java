package com.horn.edu.sso.server.service.impl;

import com.horn.edu.sso.mybatis.model.Pagination;
import com.horn.edu.sso.mybatis.service.impl.ServiceImpl;
import com.horn.edu.sso.server.dao.RoleDao;
import com.horn.edu.sso.server.model.Role;
import com.horn.edu.sso.server.service.RolePermissionService;
import com.horn.edu.sso.server.service.RoleService;
import com.horn.edu.sso.server.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by misterxu on 2018/11/6.
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role, Integer> implements RoleService {
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RolePermissionService rolePermissionService;

    @Autowired
    public void setDao(RoleDao dao) {
        this.dao = dao;
    }

    public void enable(Boolean isEnable, List<Integer> idList) {
        verifyRows(dao.enable(isEnable, idList), idList.size(), "角色数据库更新失败");
    }

    public void save(Role t) {
        super.save(t);
    }

    public Pagination<Role> findPaginationByName(String name, Pagination<Role> p) {
        dao.findPaginationByName(name, null, p);
        return p;
    }

    public List<Role> findByAll(Boolean isEnable) {
        return dao.findPaginationByName(null, isEnable, null);
    }

    @Transactional
    public void deleteById(List<Integer> idList) {
        userRoleService.deleteByRoleIds(idList);
        rolePermissionService.deleteByRoleIds(idList);
        verifyRows(dao.deleteById(idList), idList.size(), "角色数据库删除失败");
    }
}
