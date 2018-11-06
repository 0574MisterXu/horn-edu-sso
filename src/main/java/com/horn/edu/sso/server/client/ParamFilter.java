package com.horn.edu.sso.server.client;

import com.horn.edu.sso.server.rpc.AuthenticationRpcService;

/**
 * 参数注入Filter
 *
 * Created by misterxu on 2018/11/6.
 */
public class ParamFilter {
    // 单点登录服务端URL
    protected String ssoServerUrl;
    // 单点登录服务端提供的RPC服务，由Spring容器注入
    protected AuthenticationRpcService authenticationRpcService;

    public void setSsoServerUrl(String ssoServerUrl) {
        this.ssoServerUrl = ssoServerUrl;
    }

    public void setAuthenticationRpcService(AuthenticationRpcService authenticationRpcService) {
        this.authenticationRpcService = authenticationRpcService;
    }

    public AuthenticationRpcService getAuthenticationRpcService() {
        return authenticationRpcService;
    }

}
