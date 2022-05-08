package com.liuxiaocs.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * MethodInterceptor接口  额外功能
 */
public class Arround implements MethodInterceptor {

    /**
     * invoke方法的作用：额外功能书写在invoke方法中
     *                   额外功能可以运行在  ① 原始方法之前
     *                                   ② 原始方法之后
     *                                   ③ 原始方法执行之前 之后
     * 如何体现执行时机
     * 确定：原始方法怎么运行？
     * 参数：MethodInvocation: (类似Before中的Method)额外功能所增加给的那个原始方法
     *             login
     *             register
     *       invocation.proceed();   --->   login运行
     *                                      register运行
     * 返回值：Object: 原始方法的返回值
     *                 login的返回值
     *                 register的返回值
     * Date convert(String name) 提供特殊类型返回值
     */
    /*public Object invoke(MethodInvocation invocation) throws Throwable {
        // System.out.println("-----额外功能 log-----");
        System.out.println("-----额外功能运行在原始方法执行之前----");
        // 让原始方法运行
        // 获取原始方法的返回值
        // void对应的是null
        Object ret = invocation.proceed();
        System.out.println("-----额外功能运行在原始方法执行之后----");
        // 将原始方法的返回值返回回去即可
        return ret;
    }*/

    /*public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object ret = null;
        try {
            ret = methodInvocation.proceed();
        } catch (Throwable throwable) {
            System.out.println("-----原始方法抛出异常，执行额外功能-----");
            throwable.printStackTrace();
        }
        return ret;
    }*/

    /**
     * 如果把原始方法的返回值作为invoke方法的返回值返回，
     * MethodInvocation不会影响原始方法的返回值
     */
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("========log========");
        // 原始方法的返回值ret
        Object ret = methodInvocation.proceed();
        // return ret;
        // 返回自定义的值
        return false;
    }
}
