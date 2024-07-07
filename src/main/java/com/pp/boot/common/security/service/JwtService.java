package com.pp.boot.common.security.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Jwt
 *
 * @author supanpan
 * @date 2024/07/07
 */
@Service
public class JwtService {

    // 令牌自定义标识
    @Value("${token.header}")
    private String header;
    // 令牌密钥
    @Value("${token.secret-key}")
    private String secretKey;
    // 令牌有效期
    @Value("${token.expiration}")
    private long jwtExpiration;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

}
