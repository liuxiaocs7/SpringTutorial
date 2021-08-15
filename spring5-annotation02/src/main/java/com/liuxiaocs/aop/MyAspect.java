package com.liuxiaocs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    // 包切入点
    @Pointcut("execution(* com.liuxiaocs.aop..*.*(..))")
    public void pointCut() {}

    @Around("pointCut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("----Log----");
        Object proceed = joinPoint.proceed();
        return proceed;
    }
}
