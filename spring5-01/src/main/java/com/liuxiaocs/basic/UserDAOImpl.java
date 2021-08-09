package com.liuxiaocs.basic;


public class UserDAOImpl implements UserDAO {

    public void save(User user) {
        System.out.println("insert into user = " + user);
    }

    public void queryUserByNameAndPassword(String name, String password) {
        System.out.println("query User name = " + name + " password =" + password);
    }
}
