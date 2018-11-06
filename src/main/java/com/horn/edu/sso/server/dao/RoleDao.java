package com.horn.edu.sso.server.dao;

import com.horn.edu.sso.mybatis.dao.mybatis.Dao;
import com.horn.edu.sso.mybatis.model.Pagination;
import com.horn.edu.sso.server.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色持久化接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface RoleDao extends Dao<Role, Integer> {
    public int enable(@Param("isEnable") Boolean isEnable, @Param("idList") List<Integer> idList);

    public int resetPassword(@Param("password") String password, @Param("idList") List<Integer> idList);

    public List<Role> findPaginationByName(@Param("name") String name, @Param("isEnable") Boolean isEnable,
                                           Pagination<Role> p);
}
