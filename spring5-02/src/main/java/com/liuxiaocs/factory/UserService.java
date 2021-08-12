package com.liuxiaocs.factory;


import com.liuxiaocs.proxy.User;

public interface UserService {

    void login(String name, String password);

    void register(User user);
}
