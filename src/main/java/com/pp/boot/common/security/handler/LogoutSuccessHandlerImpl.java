package com.pp.boot.common.security.handler;

import com.alibaba.fastjson2.JSON;
import com.pp.boot.common.base.Result;
import com.pp.boot.common.security.model.LoginUser;
import com.pp.boot.common.security.service.TokenService;
import com.pp.boot.common.utils.MessageUtils;
import com.pp.boot.common.utils.ServletUtils;
import com.pp.boot.common.utils.StringUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;

/**
 * 自定义退出处理类 返回成功
 * @author supanpan
 * @date 2024/07/08
 */
@Configuration
@RequiredArgsConstructor
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    private static final Logger log = LoggerFactory.getLogger(LogoutSuccessHandlerImpl.class);

    private final TokenService tokenService;
    /**
     * 退出处理
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 获取当前登录的用户信息
        LoginUser loginUser = tokenService.getLoginUser(request);
        // 如果获取到用户信息，则删除token
        if (StringUtils.isNotNull(loginUser)){
            tokenService.delLoginUser(loginUser.getToken());
            // 清除安全上下文信息
            SecurityContextHolder.clearContext();
            log.info("onLogoutSuccess 用户退出成功");
        }
        ServletUtils.renderString(response, JSON.toJSONString(Result.ok(MessageUtils.message("user.logout.success"))));

    }
}
