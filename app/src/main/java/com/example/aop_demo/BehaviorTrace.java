package com.example.aop_demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 该注解标记哪些方法是 Join Point 连接点
 *      所有被该注解标记的方法构成 一组 Join Point 连接点 , 即 Point Cut 切入点
 */
@Retention(RetentionPolicy.RUNTIME) // 注解保留到运行时
@Target(ElementType.METHOD) // 注解作用于方法上
public @interface BehaviorTrace {
    String value();
}
