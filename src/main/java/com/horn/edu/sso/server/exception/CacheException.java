package com.horn.edu.sso.server.exception;

import com.horn.edu.sso.mybatis.exception.ApplicationException;
import com.horn.edu.sso.mybatis.model.ResultCode;

/**
 * 缓存异常
 *
 * Created by misterxu on 2018/11/6.
 */
public class CacheException extends ApplicationException {
    private static final long serialVersionUID = -2678203134198782909L;

    public static final String MESSAGE = "缓存异常";

    public CacheException() {
        super(MESSAGE);
    }

    public CacheException(String message) {
        super(message);
        this.code = ResultCode.CACHE_ERROR;
    }

    public CacheException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
        this.code = ResultCode.CACHE_ERROR;
    }

    public CacheException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public CacheException(Throwable cause) {
        super(cause);
        this.code = ResultCode.CACHE_ERROR;
    }
}
