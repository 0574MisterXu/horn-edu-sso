package com.horn.edu.sso.server.dao;

import com.horn.edu.sso.mybatis.dao.mybatis.Dao;
import com.horn.edu.sso.mybatis.model.Pagination;
import com.horn.edu.sso.server.model.App;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 应用持久化接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface AppDao extends Dao<App, Integer> {
    public int enable(@Param("isEnable") Boolean isEnable, @Param("idList") List<Integer> idList);

    public List<App> findPaginationByName(@Param("name") String name, @Param("isEnable") Boolean isEnable,
                                          Pagination<App> p);

    public App findByCode(@Param("code") String code);
}
