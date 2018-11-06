package com.horn.edu.sso.server.service;

/**
 * 权限修改消息服务接口
 *
 * Created by misterxu on 2018/11/6.
 */
public interface PermissionJmsService {
    /**
     * 发送权限变更消息
     *
     * @param appCode
     *            应用编码
     */
    public void send(String appCode);
}
