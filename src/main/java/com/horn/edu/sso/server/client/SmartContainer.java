package com.horn.edu.sso.server.client;

import com.caucho.hessian.client.HessianProxyFactory;
import com.horn.edu.sso.server.rpc.AuthenticationRpcService;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Smart容器中心
 *
 * Created by misterxu on 2018/11/6.
 */
public class SmartContainer extends ParamFilter implements Filter{

    // 是否服务端，默认为false
    private boolean isServer = false;

    private ClientFilter[] filters;

    private PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        if(isServer) {
            ssoServerUrl = filterConfig.getServletContext().getContextPath();
        }
        else if (StringUtils.isEmpty(ssoServerUrl)) {
            throw new IllegalArgumentException("ssoServerUrl不能为空");
        }

        if (authenticationRpcService == null) {
            try {
                authenticationRpcService = (AuthenticationRpcService) new HessianProxyFactory()
                        .create(AuthenticationRpcService.class, ssoServerUrl + "/rpc/authenticationRpcService");
            }
            catch (MalformedURLException e) {
                new IllegalArgumentException("authenticationRpcService初始化失败");
            }
        }

        if (filters == null || filters.length == 0) {
            throw new IllegalArgumentException("filters不能为空");
        }
        for (ClientFilter filter : filters) {
            filter.setSsoServerUrl(ssoServerUrl);
            filter.setAuthenticationRpcService(authenticationRpcService);

            filter.init(filterConfig);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        for (ClientFilter filter : filters) {
            if (matchPath(filter.getPattern(), httpRequest.getServletPath())
                    && !filter.isAccessAllowed(httpRequest, httpResponse)) {
                return;
            }
        }
        chain.doFilter(request, response);
    }

    private boolean matchPath(String pattern, String path) {
        return StringUtils.isEmpty(pattern) || pathMatcher.match(pattern, path);
    }

    public void setIsServer(boolean isServer) {
        this.isServer = isServer;
    }

    @Override
    public void destroy() {
        if (filters == null || filters.length == 0)
            return;
        for (ClientFilter filter : filters) {
            filter.destroy();
        }
    }

    public void setFilters(ClientFilter[] filters) {
        this.filters = filters;
    }

}
