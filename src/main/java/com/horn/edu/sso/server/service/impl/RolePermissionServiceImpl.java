package com.horn.edu.sso.server.service.impl;

import com.horn.edu.sso.mybatis.service.impl.ServiceImpl;
import com.horn.edu.sso.server.dao.RolePermissionDao;
import com.horn.edu.sso.server.model.RolePermission;
import com.horn.edu.sso.server.service.AppService;
import com.horn.edu.sso.server.service.PermissionJmsService;
import com.horn.edu.sso.server.service.RolePermissionService;
import com.horn.edu.sso.server.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by misterxu on 2018/11/6.
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionDao, RolePermission, Integer> implements RolePermissionService {
    @Resource
    private RoleService roleService;
    @Resource
    private AppService appService;
    @Resource
    private PermissionJmsService permissionJmsService;

    @Autowired
    public void setDao(RolePermissionDao dao) {
        this.dao = dao;
    }

    @Transactional
    public void allocate(Integer appId, Integer roleId, List<Integer> permissionIdList) {
        dao.deleteByAppAndRoleId(appId, roleId);

        List<RolePermission> list = new ArrayList<RolePermission>();
        Integer permissionId;
        for (Iterator<Integer> i$ = permissionIdList.iterator(); i$.hasNext(); list
                .add(new RolePermission(appId, roleId, permissionId))) {
            permissionId = i$.next();
        }
        if (!CollectionUtils.isEmpty(list)) {
            super.save(list);
        }

        // JMS通知权限变更
        permissionJmsService.send(appService.get(appId).getCode());
    }

    public List<RolePermission> findByRoleId(Integer roleId) {
        return dao.findByRoleId(roleId);
    }

    public void deleteByPermissionIds(List<Integer> idList) {
        dao.deleteByPermissionIds(idList);
    }

    public void deleteByRoleIds(List<Integer> idList) {
        dao.deleteByRoleIds(idList);
    }

    public void deleteByAppIds(List<Integer> idList) {
        dao.deleteByAppIds(idList);
    }
}
