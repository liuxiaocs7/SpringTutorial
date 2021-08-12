package com.liuxiaocs.factory;


import com.liuxiaocs.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("suns", "123456");
        userService.register(new User());
    }
}
