package com.liuxiaocs.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 工厂类，用于生产对象
 *
 * @author liuxiaocs
 * @date 2021/3/16 18:51
 */
public class BeanFactory {

    private static Properties env = new Properties();

    // IO是一种系统级资源，要避免重复打开IO，最好在程序启动时一次性读取所有内容
    static {
        try {
            // 第一步 获得IO输入流(读取Properties配置文件)
            InputStream inputStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties");
            // 第二步 将文件的内容封装到Properties集合中 key = userService  value = com.liuxiaocs.basic.UserServiceImpl
            // load方法就相当于将配置文件中的k-v加载进env
            env.load(inputStream);
            // 关闭流
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象的创建方式：
     * 1. 直接调用构造方法创建对象  UserService userService = new UserServiceImpl();
     * 这种创建方法一定会把接口的实现类硬编码在程序中，自然而然就会有耦合，要想解决这个问题，需要使用反射来创建对象
     * 2. 通过反射的形式创建对象 解耦合  全限定名(带包带类)
     * ①获取类对象：Class clazz = Class.forName("com.liuxiaocs.basic.UserServiceImpl");
     * ②通过类对象的newInstance()方法来获取对象(返回Object，需要强转)：UserService userService = (UserService)clazz.newInstance();
     *
     * @return
     */
    // 这里开始存在耦合
    public static UserService getUserService() {

        UserService userService = null;
        try {
            // Class clazz = Class.forName("com.liuxiaocs.basic.UserServiceImpl");
            // com.liuxiaocs.basic.UserServiceImplNew  如果直接这样写全限定名还是硬编码，
            // 要修改的时候还是得在代码中进行修改，可见还是存在耦合
            // 从Properties中获取值
            Class clazz = Class.forName(env.getProperty("userService"));
            userService = (UserService) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return userService;
        // return new UserServiceImpl();
    }

    /**
     * 工厂方法获取UserDAO
     *
     * @return
     */
    public static UserDAO getUserDAO() {
        UserDAO userDAO = null;
        try {
            Class clazz = Class.forName(env.getProperty("userDAO"));
            userDAO = (UserDAO) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return userDAO;
    }

    /**
     * 通用的工厂方法
     * key: 小配置文件中的key [userDAO, userService]
     *
     * @param key
     * @return
     */
    public static Object getBean(String key) {
        Object ret = null;
        try {
            Class clazz = Class.forName(env.getProperty(key));
            ret = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
