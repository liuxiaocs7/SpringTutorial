package com.liuxiaocs.aspect;


import com.liuxiaocs.Log;
import com.liuxiaocs.proxy.User;

/**
 * 原始类、目标类
 * 只完成核心功能
 */
public class UserServiceImpl implements UserService {

    @Log
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算 + DAO");
        // throw new RuntimeException("测试异常");
    }

    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
