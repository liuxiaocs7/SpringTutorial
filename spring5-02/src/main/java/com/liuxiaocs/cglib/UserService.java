package com.liuxiaocs.cglib;


import com.liuxiaocs.proxy.User;

/**
 * 原始类，一个普通的类，不需要实现接口
 */
public class UserService {

    public void login(String name, String password) {
        System.out.println("UserService.login");
    }

    public void register(User user) {
        System.out.println("UserService.register");
    }
}
