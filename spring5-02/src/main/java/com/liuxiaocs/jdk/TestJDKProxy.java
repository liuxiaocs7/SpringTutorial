package com.liuxiaocs.jdk;


import com.liuxiaocs.proxy.User;
import com.liuxiaocs.proxy.a.UserService;
import com.liuxiaocs.proxy.a.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {
    /**
     * 1. 借用类加载器  TestJDKProxy
     *                  UserServiceImpl
     * 2. JDK8.x前
     *          final UserService userService = new UserServiceImpl();
     */
    public static void main(String[] args) {
        // 1. 创建原始对象
        final UserService userService = new UserServiceImpl();

        // 2. JDK创建动态代理
        /*
            返回值就是创建的动态代理对象
            invocationhandler 对应着额外功能
            interface 原始对象所实现的接口 userService.getClass().getInterfaces() 获取类对象进而获取接口
            classloader 借用一个类加载器
         */
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("------Proxy log------");
                // 原始方法运行
                // 对象是userService，参数是args
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };
        // UserService userServiceProxy = (UserService) Proxy.newProxyInstance(TestJDKProxy.class.getClassLoader(), userService.getClass().getInterfaces(), handler);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), userService.getClass().getInterfaces(), handler);
        userServiceProxy.login("suns", "123456");
        userServiceProxy.register(new User());
    }
}
