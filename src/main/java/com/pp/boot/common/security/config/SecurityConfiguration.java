package com.pp.boot.common.security.config;

import com.pp.boot.common.config.properties.PermitAllUrlProperties;
import com.pp.boot.common.security.filter.JwtAuthenticationTokenFilter;
import com.pp.boot.common.security.handler.AuthenticationEntryPointImpl;
import com.pp.boot.common.security.handler.LogoutSuccessHandlerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.CorsFilter;


import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

/**
 * spring security配置
 *
 * @author supanpan
 * @date 2024/05/15
 */
@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)// 开启网络安全注解
@RequiredArgsConstructor
public class SecurityConfiguration {
    /**
     * 认证处理类 - ApplicationConfig -> authenticationProvider()
     */
    private final AuthenticationProvider authenticationProvider;

    /**
     * 认证失败处理类
     */
    private final AuthenticationEntryPointImpl unauthorizedHandler;

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
     * 允许匿名访问的地址
     */
    private final PermitAllUrlProperties permitAllUrl;
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
                // 禁用HTTP响应标头
                .headers((headersCustomizer) -> {
                    headersCustomizer.cacheControl(cache -> cache.disable()).frameOptions(options -> options.sameOrigin());
                })
                // 认证失败处理类
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                // 禁用session
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authorizeHttpRequests((authorizeRequests) -> {
                    permitAllUrl.getUrls().forEach(url -> authorizeRequests.requestMatchers(url).permitAll());
                    // 配置白名单URL允许匿名访问
                    authorizeRequests.requestMatchers(WHITE_LIST_URL).permitAll().anyRequest().authenticated();
                    // 对于登录login 注册register 验证码captchaImage 允许匿名访问
//                    authorizeRequests.requestMatchers("/login", "/register", "/captchaImage").permitAll()
//                            // 配置白名单URL允许匿名访问
//                            .requestMatchers(WHITE_LIST_URL).permitAll()
//                            // 静态资源，可匿名访问
//                            .requestMatchers(HttpMethod.GET, "/", "/*.html", "/**.html", "/**.css", "/**.js", "/profile/**").permitAll()
//                            .requestMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**", "/druid/**").permitAll()
//                            // 除上面外的所有请求全部需要鉴权认证
//                            .anyRequest().authenticated();
                })
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler))
                // 注册身份验证提供程序
                .authenticationProvider(authenticationProvider)
                // 添加JWT filter，指定在UsernamePasswordAuthenticationFilter之前执行
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 添加CORS filter，指定在JwtAuthenticationTokenFilter之前执行
                .addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class)
                // 添加CORS filter，指定在LogoutFilter之前执行
                .addFilterBefore(corsFilter, LogoutFilter.class);


        return http.build();
    }

}
