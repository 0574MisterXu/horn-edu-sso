package com.horn.edu.sso.mybatis.service;

import com.horn.edu.sso.mybatis.model.Pagination;
import com.horn.edu.sso.mybatis.model.PersistentObject;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Service接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface Service<T extends PersistentObject, ID extends Serializable> {
    /**
     * 查询所有分页
     *
     * @param p
     * @return
     */
    public Pagination<T> findByAllPagination(Pagination<T> p);

    /**
     * 通过主键查询实体
     *
     * @param pk
     * @return T
     */
    public T get(ID pk);

    /**
     * 通过主键集合查询实体
     *
     * @param pks
     * @return List<T>
     */
    public List<T> get(Collection<ID> pks);

    /**
     * 插入/更新实体
     *
     * @param t
     */
    public void save(T t);

    /**
     * 插入/更新实体集合
     *
     * @param ts
     */
    public void save(Collection<T> ts);

    /**
     * 更新实体
     *
     * @param t
     */
    public void update(T t);

    /**
     * 更新实体集合
     *
     * @param ts
     */
    public void update(Collection<T> ts);

    /**
     * 删除实体
     *
     * @param t
     */
    public void delete(T t);

    /**
     * 删除实体集合
     *
     * @param ts
     */
    public void delete(Collection<T> ts);

    /**
     * 通过主键删除实体
     *
     * @param id
     * @return T
     */
    public void deleteById(ID id);

    /**
     * 通过主键集合删除实体 注：这里别把List改为Collection，会导致覆盖方法的List<ID>调用不到
     *
     * @param idList
     * @return List<T>
     */
    public void deleteById(List<ID> idList);
}
