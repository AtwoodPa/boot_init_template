package com.pp.boot.common.security.filter;

import com.pp.boot.common.security.model.LoginUser;
import com.pp.boot.common.security.service.TokenService;
import com.pp.boot.common.security.util.SecurityUtils;
import com.pp.boot.common.utils.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * token过滤器 验证token有效性
 *
 * @author supanpan
 * @date 2024/07/08
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    // token服务
    private final TokenService tokenService;
    /**
     * {@inheritDoc}
     * 覆盖父类方法，实现自定义的过滤器逻辑。
     *
     * @param request      当前HTTP请求
     * @param response     当前HTTP响应
     * @param filterChain  过滤器链，用于继续处理后续的过滤器或目标资源
     * @throws ServletException 如果在过滤器处理期间发生Servlet异常，则抛出此异常
     * @throws IOException    如果在过滤器处理期间发生IO异常，则抛出此异常
     */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        // 判断请求路径是否包含"/api/v1/auth"，如果包含，则直接调用过滤器链的下一个过滤器
        if (request.getServletPath().contains("/api/v1/auth")) {
            // 如果是，则直接调用过滤器链的下一个过滤器
            filterChain.doFilter(request, response);
            return;
        }
        // 获取请求头中的"Authorization"字段
        final String authHeader = request.getHeader("Authorization");
        // 如果请求头中没有"Authorization"字段，或者"Authorization"字段不以"Bearer "开头
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            // 则直接调用过滤器链的下一个过滤器
            filterChain.doFilter(request, response);
            return;
        }
        // 获取登录用户信息
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser) && StringUtils.isNull(SecurityUtils.getAuthentication())) {
            // 验证token有效性
            tokenService.verifyToken(loginUser);
            // 创建一个UsernamePasswordAuthenticationToken对象，并设置 用户详细信息 和 权限信息
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            // 设置认证详细信息为Web认证详情
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        // 放行
        filterChain.doFilter(request, response);
    }
}
