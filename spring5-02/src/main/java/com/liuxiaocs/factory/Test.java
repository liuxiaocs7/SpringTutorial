package com.liuxiaocs.factory;


import com.liuxiaocs.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        // 获取的实际上是加工好的代理对象
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("suns", "123456");
        userService.register(new User());
    }
}
