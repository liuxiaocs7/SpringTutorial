package com.liuxiaocs.proxy;


/**
 * 代理类
 */
public class OrderServiceProxy implements OrderService {

    private OrderServiceImpl orderService = new OrderServiceImpl();

    public void showOrder() {
        System.out.println("-----log-----");
        orderService.showOrder();
    }
}
