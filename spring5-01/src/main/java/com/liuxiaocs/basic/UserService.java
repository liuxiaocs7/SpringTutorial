package com.liuxiaocs.basic;

/**
 * 用户服务接口
 */
public interface UserService {

    void register(User user);

    void login(String name, String password);
}
