package com.pp.boot.common.security.config;

import com.pp.boot.common.security.filter.JwtAuthenticationTokenFilter;
import com.pp.boot.common.security.handler.LogoutSuccessHandlerImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.filter.CorsFilter;

import java.io.IOException;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

/**
 * @author supanpan
 * @date 2024/05/15
 */
@Configuration
@EnableWebSecurity// 开启网络安全注解
@RequiredArgsConstructor
public class SecurityConfiguration {

    /**
     * 退出处理类
     */
    private final LogoutSuccessHandlerImpl logoutSuccessHandler;
    /**
     * token认证过滤器
     */
    private final JwtAuthenticationTokenFilter authenticationTokenFilter;
    /**
     * 跨域过滤器
     */
    private final CorsFilter corsFilter;
    /**
     * 配置白名单地址
     */
    private static final String[] WHITE_LIST_URL = {
            "/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
//                                .requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())
//                                .requestMatchers(GET, "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
//                                .requestMatchers(POST, "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
//                                .requestMatchers(PUT, "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
//                                .requestMatchers(DELETE, "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
                                .anyRequest()
                                .authenticated()
                )
                // 禁用session
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .logout().logoutUrl("/api/v1/auth/logout").logoutSuccessHandler(logoutSuccessHandler)
                .and()
//                .authenticationProvider(authenticationProvider)
                // 添加JWT filter，指定在UsernamePasswordAuthenticationFilter之前执行
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 添加CORS filter，指定在JwtAuthenticationTokenFilter之前执行
                .addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class)
                // 添加CORS filter，指定在LogoutFilter之前执行
                .addFilterBefore(corsFilter, LogoutFilter.class)
        ;


        return http.build();
    }

}
