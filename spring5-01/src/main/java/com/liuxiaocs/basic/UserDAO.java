package com.liuxiaocs.basic;

/**
 * @author liuxiaocs
 * @date 2021/3/16 18:42
 */
public interface UserDAO {

    void save(User user);

    void queryUserByNameAndPassword(String name, String password);
}
