package com.it6666.aspectj.annotation;

import com.it6666.aspectj.enums.BusinessType;
import com.it6666.aspectj.enums.OperatorType;

import java.lang.annotation.*;

/**
 * description: 自定义操作日志记录注解
 * date: 2020-09-12 10:05
 * author: 30315
 * version: 1.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}