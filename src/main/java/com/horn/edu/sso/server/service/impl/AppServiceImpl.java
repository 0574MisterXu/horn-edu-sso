package com.horn.edu.sso.server.service.impl;

import com.horn.edu.sso.mybatis.model.Pagination;
import com.horn.edu.sso.mybatis.service.impl.ServiceImpl;
import com.horn.edu.sso.server.dao.AppDao;
import com.horn.edu.sso.server.model.App;
import com.horn.edu.sso.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by misterxu on 2018/11/6.
 */
@Service("appService")
public class AppServiceImpl extends ServiceImpl<AppDao, App, Integer> implements AppService {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RolePermissionService rolePermissionService;

    @Autowired
    public void setDao(AppDao dao) {
        this.dao = dao;
    }

    public void enable(Boolean isEnable, List<Integer> idList) {
        verifyRows(dao.enable(isEnable, idList), idList.size(), "应用数据库更新失败");
    }

    public void save(App t) {
        super.save(t);
    }

    public List<App> findByAll(Boolean isEnable) {
        return dao.findPaginationByName(null, isEnable, null);
    }

    public Pagination<App> findPaginationByName(String name, Pagination<App> p) {
        dao.findPaginationByName(name, null, p);
        return p;
    }

    public App findByCode(String code) {
        return dao.findByCode(code);
    }

    @Transactional
    public void deleteById(List<Integer> idList) {
        rolePermissionService.deleteByAppIds(idList);
        permissionService.deleteByAppIds(idList);
        verifyRows(dao.deleteById(idList), idList.size(), "应用数据库删除失败");
    }
}
