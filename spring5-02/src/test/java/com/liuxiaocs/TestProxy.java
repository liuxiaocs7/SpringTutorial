package com.liuxiaocs;


import com.liuxiaocs.proxy.*;
import com.liuxiaocs.proxy.a.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {

    /**
     * 用于测试：静态代理的代码
     */
    @Test
    public void test1() {
        // 使用接口来接收
        UserService userService = new UserServiceProxy();
        userService.login("suns", "123456");
        userService.register(new User());

        System.out.println("======================================");
        OrderService orderService = new OrderServiceProxy();
        orderService.showOrder();
    }

    /**
     * 用于测试：Spring的动态代理
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 实际获取的是代理对象，而不是原始对象了
        UserService userService = (UserService) ctx.getBean("userService");
        boolean result = userService.login("suns", "123456");
        System.out.println("result = " + result);
        userService.register(new User());
    }

    /**
     * 用于测试：OrderService动态代理
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // OrderService代理类对象
        OrderService orderService = (OrderService) ctx.getBean("orderService");
        orderService.showOrder();
    }
}
