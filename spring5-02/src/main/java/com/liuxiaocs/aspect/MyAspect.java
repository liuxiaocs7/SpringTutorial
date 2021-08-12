package com.liuxiaocs.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面类
 * 需要增加 @Aspect 注解
 * 1. 额外功能
 *    public class MyArround implements MethodInterceptor {
 *        public Object invoke(MethodInvocation invocation) {
 *            // 额外功能
 *            Object ret = invocation.proceed();
 *            // 额外功能
 *            return ret;
 *        }
 *    }
 * 2. 切入点
 *    <aop:config
 *        <aop:pointcut id="" expression="execution(* login(..))"/>
 */
@Aspect
public class MyAspect {

    /**
     * 切入点复用：将切入点配置提取到一个独立的函数上
     * public void xxx() {}
     *
     * 只定义一次，使用时调用对象的函数即可
     */
    // @Pointcut("execution(* login(..))")
    // 类切入点
    @Pointcut("execution(* *..UserServiceImpl.*(..))")
    public void myPointcut() {

    }

    /**
     * 等同于之前的invoke方法
     * 方法名可以随便命名
     * Object代表原始方法的返回值
     * ProceedingJoinPoint等同于之前的MethodInvocation即原始方法
     *
     * 将抽取出来的切入点加到Around上
     */
    // @Around("execution(* login(..))")
    @Around(value = "myPointcut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----aspect log----");
        Object ret = joinPoint.proceed();
        return ret;
    }

    /**
     * 添加事务
     */
    // @Around("execution(* login(..))")
    @Around(value = "myPointcut()")
    public Object arround1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----aspect tx----");
        Object ret = joinPoint.proceed();
        return ret;
    }
}
