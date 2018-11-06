package com.horn.edu.sso.server.dao;

import com.horn.edu.sso.mybatis.dao.mybatis.Dao;
import com.horn.edu.sso.mybatis.model.Pagination;
import com.horn.edu.sso.server.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户持久化接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface UserDao extends Dao<User, Integer> {
    public int enable(@Param("isEnable") Boolean isEnable, @Param("idList") List<Integer> idList);

    public int resetPassword(@Param("password") String password, @Param("idList") List<Integer> idList);

    public List<User> findPaginationByAccount(@Param("account") String account, Pagination<User> p);

    public User findByAccount(@Param("account") String account);
}
