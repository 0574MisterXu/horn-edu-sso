package com.horn.edu.sso.server.service.impl;

import com.horn.edu.sso.mybatis.service.impl.ServiceImpl;
import com.horn.edu.sso.server.dao.UserRoleDao;
import com.horn.edu.sso.server.model.UserRole;
import com.horn.edu.sso.server.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by misterxu on 2018/11/6.
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole, Integer> implements UserRoleService {
    @Autowired
    public void setDao(UserRoleDao dao) {
        this.dao = dao;
    }

    @Transactional
    public void allocate(Integer userId, List<UserRole> list) {
        dao.deleteByUserIds(Arrays.asList(userId));
        super.save(list);
    }

    public UserRole findByUserRoleId(Integer userId, Integer roleId) {
        return dao.findByUserRoleId(userId, roleId);
    }

    public void deleteByRoleIds(List<Integer> idList) {
        dao.deleteByRoleIds(idList);
    }

    public void deleteByUserIds(List<Integer> idList) {
        dao.deleteByUserIds(idList);
    }
}
