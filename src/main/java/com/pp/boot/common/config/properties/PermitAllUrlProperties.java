package com.pp.boot.common.config.properties;

import com.pp.boot.common.annotation.Anonymous;
import org.apache.commons.lang3.RegExUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.AnnotatedElement;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 设置Anonymous注解允许匿名访问的url
 * 这个配置类用于在Spring启动后自动扫描带有@Anonymous注解的控制器和方法，并将其URL存储在urls列表中
 * 在URL中，路径变量（Path Variables）会被替换为星号（*）
 *
 * @author supanpan
 * @date 2024/07/08
 */
@Configuration
public class PermitAllUrlProperties implements InitializingBean, ApplicationContextAware {
    // 用于匹配路径变量的正则表达式
    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");

    private ApplicationContext applicationContext;

    // 存储允许匿名访问的URL列表
    private List<String> urls = new ArrayList<>();

    public String ASTERISK = "*";

    /**
     * Spring启动后调用的方法
     * 这个方法会扫描所有RequestMapping，并处理带有@Anonymous注解的方法和控制器
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // 获取RequestMappingHandlerMapping，用于获取所有的URL映射
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 从mapping中获取所有的URL映射
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        // 遍历每个URL映射
        map.keySet().forEach(info -> {
            // 获取handlerMethod，即处理该URL的具体方法
            HandlerMethod handlerMethod = map.get(info);
            // 获取方法上边的注解 替代path variable 为 *
            Anonymous method = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), Anonymous.class);
            Optional.ofNullable(method).ifPresent(anonymous -> Objects.requireNonNull(info.getPatternsCondition().getPatterns())
                    .forEach(url -> urls.add(RegExUtils.replaceAll(url, PATTERN, ASTERISK))));

            // 获取类上边的注解, 替代path variable 为 *
            Anonymous controller = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), Anonymous.class);
            Optional.ofNullable(controller).ifPresent(anonymous -> Objects.requireNonNull(info.getPatternsCondition().getPatterns())
                    .forEach(url -> urls.add(RegExUtils.replaceAll(url, PATTERN, ASTERISK))));
        });
    }

    /**
     * 设置ApplicationContext
     * 这个方法在Spring初始化时会被调用，用于传入ApplicationContext
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    // 获取允许匿名访问的URL列表
    public List<String> getUrls() {
        return urls;
    }

    // 设置允许匿名访问的URL列表
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
