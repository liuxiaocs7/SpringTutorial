package com.liuxiaocs.factory;


import com.liuxiaocs.proxy.User;

public class UserServiceImpl implements UserService {

    public void login(String name, String password) {
        System.out.println("UserServiceImpl.login");
    }

    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }
}
