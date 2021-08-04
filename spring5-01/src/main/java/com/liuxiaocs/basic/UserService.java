package com.liuxiaocs.basic;

/**
 * 用户服务接口
 *
 * @author liuxiaocs
 * @date 2021/3/16 18:42
 */
public interface UserService {

    void register(User user);

    void login(String name, String password);
}
