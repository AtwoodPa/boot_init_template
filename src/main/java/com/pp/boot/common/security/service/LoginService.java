package com.pp.boot.common.security.service;

import com.pp.boot.common.base.Constants;
import com.pp.boot.common.cache.RedisCache;
import com.pp.boot.common.exception.ServiceException;
import com.pp.boot.common.exception.UserPasswordNotMatchException;
import com.pp.boot.common.security.context.AuthenticationContextHolder;
import com.pp.boot.common.security.model.LoginUser;
import com.pp.boot.common.utils.DateUtils;
import com.pp.boot.common.utils.IpUtils;
import com.pp.boot.model.core.SysUser;
import com.pp.boot.services.system.SysUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author supanpan
 * @date 2024/07/08
 */
@Service
@RequiredArgsConstructor
public class LoginService {
    // protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final RedisCache redisCache;
    private final SysUserService userService;


    public String login(String username, String password, String code, String uuid) {
        // 用户验证
        Authentication authentication = null;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            AuthenticationContextHolder.setContext(authenticationToken);
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new UserPasswordNotMatchException();
            } else {
                throw new ServiceException(e.getMessage());
            }
        } finally {
            AuthenticationContextHolder.clearContext();
        }
        // logger.debug("login success: {}", authentication);

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 记录用户登录信息
        recordLoginInfo(loginUser.getUserId());
        // 生成token
        return tokenService.createToken(loginUser);
    }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setLoginIp(IpUtils.getIpAddr());
        sysUser.setLoginDate(DateUtils.getNowDate());
        userService.updateUserProfile(sysUser);
    }
}
