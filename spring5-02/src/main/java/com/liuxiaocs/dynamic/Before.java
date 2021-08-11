package com.liuxiaocs.dynamic;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 额外功能写在接口的实现中
 */
public class Before implements MethodBeforeAdvice {

    /*
        作用：需要把运行在原始方法执行之前运行的额外功能，书写在before方法中
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("-----method before advice log-----");
    }
}
