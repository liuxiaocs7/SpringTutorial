package com.liuxiaocs.service;


import com.liuxiaocs.entity.User;

public interface UserService {

    void register(User user);
    // void register(User user) throws Exception;

    void login(String name, String password);
}
