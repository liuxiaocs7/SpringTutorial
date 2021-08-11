package com.liuxiaocs.dynamic;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 额外功能写在接口的实现中
 */
public class Before1 implements MethodBeforeAdvice {

    /*
        作用：需要把运行在原始方法执行之前运行的额外功能，书写在before方法中
        Method: 额外功能所增加给的那个原始方法(变化的)
                1. login()方法
                2. register()方法
        Object[]: 额外功能所增加给的那个原始方法的参数。与Method参数息息相关
                1. String name, String password  (login方法的原始参数)
                2. User user  (register方法的原始参数)

        Object: 额外功能所增加给的那个原始对象
                UserServiceImpl   如果额外功能给了login()或register()
                OrderServiceImpl  如果额外功能给了showOrder()
     */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("-----new method before advice log-----");
    }
}
