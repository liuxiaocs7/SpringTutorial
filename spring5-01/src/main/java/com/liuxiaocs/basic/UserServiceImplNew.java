package com.liuxiaocs.basic;

/**
 * 新改的UserService实现类，此时不需要改变其他的任何一行代码，只需要扩充新增[对修改关闭，对扩展开放]
 * 在配置文件Properties中修改为新的类全限定名
 *
 * @author liuxiaocs
 * @date 2021/3/16 18:42
 */
public class UserServiceImplNew implements UserService {

    private UserDAO userDao = new UserDAOImpl();

    public void register(User user) {
        System.out.println("UserServiceImplNew.register");
    }

    public void login(String name, String password) {
        System.out.println("UserServiceImplNew.login");
    }
}
