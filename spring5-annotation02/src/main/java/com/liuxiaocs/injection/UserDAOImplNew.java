package com.liuxiaocs.injection;

/**
 * 对UserDAO接口一个新的实现类
 */
public class UserDAOImplNew implements UserDAO {

    @Override
    public void save() {
        System.out.println("UserDAOImplNew.save");
    }
}
