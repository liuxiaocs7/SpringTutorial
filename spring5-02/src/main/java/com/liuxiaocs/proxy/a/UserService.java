package com.liuxiaocs.proxy.a;


import com.liuxiaocs.proxy.User;

public interface UserService {

    void register(User user);

    boolean login(String name, String password);
}
