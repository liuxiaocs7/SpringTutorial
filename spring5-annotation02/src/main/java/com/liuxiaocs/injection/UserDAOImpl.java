package com.liuxiaocs.injection;

// @Repository
public class UserDAOImpl implements UserDAO {

    @Override
    public void save() {
        System.out.println("UserDAOImpl.save");
    }
}
