package com.example.aop_demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 定义 Aspect 切面
 */
@Aspect
public class BehaviorAspect {

    /**
     * 定义切入点
     * "execution(@com.example.aop_demo.BehaviorTrace * *(..))" 表示
     *      带有 @com.example.aop_demo.BehaviorTrace 注解的
     *      所有包下面的 所有类中的 所有方法, 方法参数不限
     *      上述方法组成 切入点 , 每个方法都是一个 Join Point 连接点
     *
     * execution(@com.example.aop_demo.BehaviorTrace * *(..)) 解读
     *  - @com.example.aop_demo.BehaviorTrace 表示带该注解的方法
     *  - 第 1 个 * 表示在所有包下面
     *  - 第 2 个 * 表示在所有类下面
     *  - (..) 表示所有方法 , 参数不限
     *
     *  所有的包 所有的类 中 , 带有 @com.example.aop_demo.BehaviorTrace 注解的方法 , 都是 Pointcut 切入点
     *      上述每个方法都是一个 Join Point 连接点
     */
    @Pointcut("execution(@com.example.aop_demo.BehaviorTrace * *(..))")
    public void pointCut(){}

    /**
     * 逐个处理 Pointcut 切入点 中的 JoinPoint 连接点
     *      一个一个处理
     *
     * @Around("pointCut()") 注解中传入的注解属性是
     *      切入点的名称 , 就是上面定义的 public void pointCut(){} 方法
     *
     * @param joinPoint
     * @return
     */
    @Around("pointCut()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            // 获取方法上 @BehaviorTrace("onClick") 注解中的注解属性 字符串
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();

            //00:18:06

            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

}
