package com.horn.edu.sso.mybatis.dao.mybatis;

import com.horn.edu.sso.mybatis.model.Pagination;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Dao接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface Dao<T, ID extends Serializable> {

    /**
     * 查询所有分页
     *
     * @param p
     * @return
     */
    public List<T> findByAll(Pagination<T> p);

    /**
     * 通过主键查询实体
     *
     * @param pk
     * @return T
     */
    public T get(ID pk);

    /**
     * 插入实体
     *
     * @param t
     */
    public int insert(T t);

    /**
     * 更新实体
     *
     * @param t
     */
    public int update(T t);

    /**
     * 删除实体
     *
     * @param t
     */
    public int deleteById(Collection<ID> idList);
}
