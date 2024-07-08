package com.pp.boot.common.annotation;

import java.lang.annotation.*;

/**
 * 匿名访问注解
 *
 * @author supanpan
 * @date 2024/07/08
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Anonymous {
}
