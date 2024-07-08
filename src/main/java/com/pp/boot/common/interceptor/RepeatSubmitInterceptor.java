package com.pp.boot.common.interceptor;

import com.alibaba.fastjson2.JSON;
import com.pp.boot.common.annotation.RepeatSubmit;
import com.pp.boot.common.base.Result;
import com.pp.boot.common.utils.ServletUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;

/**
 * 重复提交拦截器
 *
 * @author supanpan
 * @date 2024/07/08
 */
@Component
public abstract class RepeatSubmitInterceptor implements HandlerInterceptor {
    /**
     * {@inheritDoc}
     * 在请求处理之前调用，用于处理重复提交的请求
     *
     * @param request  当前的HTTP请求
     * @param response 当前的HTTP响应
     * @param handler  处理器，可以是Controller的方法或其他
     * @return 如果处理成功，返回true；如果处理失败（例如检测到重复提交），则返回false
     * @throws Exception 如果在处理过程中发生异常，则抛出该异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // 判断方法上是否有@RepeatSubmit注解
            RepeatSubmit annotation = method.getAnnotation(RepeatSubmit.class);
            if (annotation != null) {
                if (this.isRepeatSubmit(request, annotation)) {
                    Result ajaxResult = Result.fail(annotation.message());
                    ServletUtils.renderString(response, JSON.toJSONString(ajaxResult));
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    /**
     * 验证是否重复提交由子类实现具体的防重复提交的规则
     *
     * @param request    请求信息
     * @param annotation 防重复注解参数
     * @return 结果
     * @throws Exception
     */
    public abstract boolean isRepeatSubmit(HttpServletRequest request, RepeatSubmit annotation);

}
