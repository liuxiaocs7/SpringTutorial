package com.liuxiaocs.basic;

/**
 * @author liuxiaocs
 * @date 2021/3/16 18:42
 */
public class UserServiceImpl implements UserService {

    // 这里也存在耦合
    // private UserDAO userDao = new UserDAOImpl();

    // 使用工厂方法获取userDAO
    // private UserDAO userDAO = BeanFactory.getUserDAO();

    // 使用通用工厂方法获取
    // private UserDAO userDAO = (UserDAO) BeanFactory.getBean("userDAO");

    // 通过Spring的方式完成注入
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register(User user) {
        userDAO.save(user);
    }

    public void login(String name, String password) {
        userDAO.queryUserByNameAndPassword(name, password);
    }
}
