package com.liuxiaocs.cglib;


import com.liuxiaocs.proxy.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCglib {
    public static void main(String[] args) {
        // 1. 创建原始对象
        final UserService userService = new UserService();
        /*
        2. 通过cglib方式创建动态代理对象
            相关的Jar包Spring已经默认帮我们引入进来了
            Proxy.newProxyInstance(classloader, interface, invocationhandler)
            不需要接口，需要父类
            Enhancer.setClassLoader();  设置类加载器
            Enhancer.setSuperClass();   设置父类
            Enhancer.setCallback();  ---> MethodInterceptor(cglib包的)

            Enhancer.create()  --->  代理
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(TestCglib.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());

        MethodInterceptor interceptor = new MethodInterceptor() {
            // 等同于InvocationHandler --- invoke
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("-----cglib log-----");
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };
        enhancer.setCallback(interceptor);

        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("suns", "123456");
        userServiceProxy.register(new User());
    }
}
