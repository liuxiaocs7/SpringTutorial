package com.liuxiaocs.proxy;


import com.liuxiaocs.proxy.a.UserService;
import com.liuxiaocs.proxy.a.UserServiceImpl;

/**
 * 代理类：为原始类增加功能
 *
 * 1. 实现相同接口
 * 2. 有原始类对象
 * 3. 增加额外的功能
 */
public class UserServiceProxy implements UserService {
    // 原始类对象，为其增加额外功能
    private UserServiceImpl userService = new UserServiceImpl();

    public void register(User user) {
        // 增加额外功能
        System.out.println("-----log-----");
        // 调用原始对象同名的原始方法
        userService.register(user);
    }

    public boolean login(String name, String password) {
        System.out.println("-----log-----");
        return userService.login(name, password);
    }
}
