package com.horn.edu.sso.server.provider;

import java.util.UUID;

/**
 * id生成工具
 *
 * Created by misterxu on 2018/11/6.
 */
public class IdProvider {

    /**
     * 通过uuid生成唯一的记录id
     *
     * @return 生成的id
     */
    public static String createUUIDId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }
}
