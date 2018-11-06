package com.horn.edu.sso.server.service;

import com.horn.edu.sso.mybatis.model.Pagination;
import com.horn.edu.sso.mybatis.service.Service;
import com.horn.edu.sso.server.model.App;

import java.util.List;

/**
 * 应用服务接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface AppService extends Service<App, Integer> {
    /**
     * 启用禁用操作
     * @param isEnable 是否启用
     * @param idList 应用ID集合
     * @return
     */
    public void enable(Boolean isEnable, List<Integer> idList);

    /**
     * 根据名称查询
     * @param isEnable 是否启用
     * @return
     */
    public List<App> findByAll(Boolean isEnable);

    /**
     * 根据名称分页查询
     * @param name 应用名称
     * @return
     */
    public Pagination<App> findPaginationByName(String name, Pagination<App> p);

    /**
     * 根据应用编码查询
     * @param code 应用编码
     * @return
     */
    public App findByCode(String code);
}
