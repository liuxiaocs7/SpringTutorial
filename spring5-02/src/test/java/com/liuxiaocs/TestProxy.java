package com.liuxiaocs;


import com.liuxiaocs.proxy.*;
import org.junit.Test;

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
}
