package com.liuxiaocs.aspect;


import com.liuxiaocs.Log;
import com.liuxiaocs.proxy.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 原始类、目标类
 * 只完成核心功能
 *
 * 实现 ApplicationContextAware 接口
 */
public class UserServiceImpl implements UserService, ApplicationContextAware {

    private ApplicationContext ctx;

    /**
     * 将测试类中创建的工厂交给本类UserServiceImpl
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    @Log
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算 + DAO");
        // throw new RuntimeException("测试异常");

        // 调用的是本类(原始类、原始对象)的login()方法，不会被加上额外功能，只能完成核心功能
        // this.login();

        // 同一个Service业务类中不同的业务方法之间会有相互调用的可能
        // 此时调用的是原始对象的login方法 ---> 核心功能
        /**
         * 设计目的：代理对象的login方法 ---> 额外功能+核心功能
         * 获取代理对象
         * ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
         * UserService userService = (UserService) ctx.getBean("userService");
         * userService.login();
         *
         * Spring工厂重量级资源 一个应用中应该只创建一个工厂
         * 直接拿到测试类中创建的工厂使用即可
         */
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("suns", "123456");
    }

    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
