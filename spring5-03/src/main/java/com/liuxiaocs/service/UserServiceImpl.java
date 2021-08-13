package com.liuxiaocs.service;


import com.liuxiaocs.dao.UserDAO;
import com.liuxiaocs.entity.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类中的所有方法都加上了事务
 * 切入点
 * 默认都是使用事务属性的默认值
 */
// @Transactional(rollbackFor = {java.lang.Exception.class})
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

    /**
     * 由事务的原子性可知，下面这两行代码要么一起成功，要么一起失败
     * 如果某一行代码出现问题，将会进行回滚
     * 异常将会导致整体失败
     */
    // @Override
    // public void register(User user) throws Exception{
    //     // 睡眠3秒
    //     // try {
    //     //     Thread.currentThread().sleep(3000);
    //     // } catch (InterruptedException e) {
    //     //     e.printStackTrace();
    //     // }
    //     userDAO.save(user);
    //     // throw new RuntimeException("测试");
    //     throw new Exception("测试2");
    // }


    @Override
    public void register(User user) throws Exception {
        userDAO.save(user);
    }

    /**
     * 在login()方法中设置个性化注解
     */
    @Override
    // @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void login(String name, String password) {

    }
}
