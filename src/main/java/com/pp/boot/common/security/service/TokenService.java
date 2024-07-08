package com.pp.boot.common.security.service;

import com.pp.boot.common.base.Constants;
import com.pp.boot.common.cache.CacheConstants;
import com.pp.boot.common.cache.RedisCache;
import com.pp.boot.common.security.model.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.concurrent.TimeUnit;

/**
 * Jwt
 *
 * @author supanpan
 * @date 2024/07/07
 */
@Service
@RequiredArgsConstructor
public class TokenService {
    // 日志
    private static final Logger log = LoggerFactory.getLogger(TokenService.class);

    // 令牌自定义标识
    @Value("${token.header}")
    private String header;
    // 令牌密钥
    @Value("${token.secretKey}")
    private String secretKey;
    // 令牌有效期
    @Value("${token.expireTime}")
    private int expireTime;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    // 引入Redis
    private final RedisCache redisCache;


    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public LoginUser getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StringUtils.isEmpty(token)) {
            try {
                // 解析token信息
                Claims claims = parseToken(token);
                // 解析对应的权限以及用户信息
                String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
                String userKey = getTokenKey(uuid);
                LoginUser user = redisCache.getCacheObject(userKey);
                return user;
            } catch (Exception e) {
                log.error("获取用户信息异常'{}'", e.getMessage());
            }
        }
        return null;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 解码获取s_key
     *
     * @return
     */
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * 获取请求token
     *
     * @param request
     * @return token令牌
     */
    private String getToken(HttpServletRequest request) {
        // 从请求头中获得token令牌
        String token = request.getHeader(header);
        if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

    /**
     * 获取缓存中的令牌Key
     *
     * @param uuid
     * @return
     */
    private String getTokenKey(String uuid) {
        return CacheConstants.LOGIN_TOKEN_KEY + uuid;
    }

    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param loginUser
     * @return 令牌
     */
    public void verifyToken(LoginUser loginUser) {
        log.info("verifyToken 验证令牌有效期，相差不足20分钟，自动刷新缓存");
        // 获取过期时间
        long expireTime = loginUser.getExpireTime();
        // 当前时间
        long currentTime = System.currentTimeMillis();
        // 判断是否过期，过期则刷新
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
            refreshToken(loginUser);
        }
    }

    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    private void refreshToken(LoginUser loginUser) {
        log.info("refreshToken 刷新令牌有效期");
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(System.currentTimeMillis() + expireTime * MILLIS_SECOND);
        // 根据uuid将登录信息存入缓存
        String userKey = getTokenKey(loginUser.getToken());
        redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
    }

    /**
     * 删除用户缓存记录
     * @param token
     */
    public void delLoginUser(String token) {
        if (StringUtils.isNotEmpty(token)) {
            // 获取缓存中存储的Key
            String userKey = getTokenKey(token);
            // 删除缓存中的用户信息
            redisCache.deleteObject(userKey);
        }
    }
}
