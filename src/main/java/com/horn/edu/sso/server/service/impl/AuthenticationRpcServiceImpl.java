package com.horn.edu.sso.server.service.impl;

import com.horn.edu.sso.mybatis.util.StringUtils;
import com.horn.edu.sso.server.common.LoginUser;
import com.horn.edu.sso.server.common.TokenManager;
import com.horn.edu.sso.server.rpc.AuthenticationRpcService;
import com.horn.edu.sso.server.rpc.RpcPermission;
import com.horn.edu.sso.server.rpc.RpcUser;
import com.horn.edu.sso.server.service.PermissionService;
import com.horn.edu.sso.server.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by misterxu on 2018/11/6.
 */
@Service("authenticationRpcService")
public class AuthenticationRpcServiceImpl implements AuthenticationRpcService {
    @Resource
    private PermissionService permissionService;
    @Resource
    private UserService userService;
    @Resource
    private TokenManager tokenManager;

    @Override
    public boolean validate(String token) {
        return tokenManager.validate(token) != null;
    }

    @Override
    public RpcUser findAuthInfo(String token) {
        LoginUser user = tokenManager.validate(token);
        if (user != null) {
            return new RpcUser(user.getAccount());
        }
        return null;
    }

    @Override
    public List<RpcPermission> findPermissionList(String token, String appCode) {
        if (StringUtils.isBlank(token)) {
            return permissionService.findListById(appCode, null);
        }
        else {
            LoginUser user = tokenManager.validate(token);
            if (user != null) {
                return permissionService.findListById(appCode, user.getUserId());
            }
            else {
                return new ArrayList<RpcPermission>(0);
            }
        }
    }
}
