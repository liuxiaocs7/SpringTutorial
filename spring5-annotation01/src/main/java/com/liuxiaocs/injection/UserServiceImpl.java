package com.liuxiaocs.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    // @Autowired
    // @Qualifier("userDAOImpl")

    // @Resource(name="userDAOImpl")
    // 不设置name就基于类型进行注解
    @Resource
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * 调用set方法完成注入
     */
    // @Autowired
    // @Qualifier("userDAOImpl")
    // @Qualifier("userDAO")
    public void setUserDAO(UserDAO userDAO) {
        System.out.println("UserServiceImpl.setUserDAO");
        this.userDAO = userDAO;
    }

    @Override
    public void register() {
        userDAO.save();
    }
}
