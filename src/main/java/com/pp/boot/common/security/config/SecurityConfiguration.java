package com.pp.boot.common.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author supanpan
 * @date 2024/05/15
 */
@Configuration
@EnableWebSecurity// 开启网络安全注解
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 禁用 CSRF (防止跨站请求伪造攻击)
                .csrf().disable()
                // 配置请求权限规则
                .authorizeHttpRequests(authz -> authz.anyRequest().permitAll()
//                        // 对静态资源路径进行放行（不进行校验）
                        // .requestMatchers("/swagger-ui/**", "/druid/**").permitAll()
//                        // 其他请求需要进行校验
//                        .anyRequest().authenticated()
                )
                // 禁用缓存
                .headers(headers -> headers.cacheControl().disable())
                // 禁用 session（使用无状态认证）
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}
