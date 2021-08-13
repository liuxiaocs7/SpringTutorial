package com.liuxiaocs.service;


import com.liuxiaocs.dao.UserDAO;
import com.liuxiaocs.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类中的所有方法都加上了事务
 * 切入点
 */
@Transactional
public class UserServiceImpl implements UserService {

    // 原始对象，核心功能(业务运算，DAO的调用)
    // 需要DAO，依赖DAO，将DAO作为成员变量通过Spring的配置文件来注入
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) {
        userDAO.save(user);
    }
}
