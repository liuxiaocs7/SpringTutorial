package com.liuxiaocs;


import com.liuxiaocs.mybatis.MyBatisAutoConfiguration;
import com.liuxiaocs.mybatis.User;
import com.liuxiaocs.mybatis.UserDAO;
import com.liuxiaocs.mybatis.UserService;
import com.liuxiaocs.yml.Account;
import com.liuxiaocs.yml.YmlAutoConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestAnnotation2 {

    /**
     * 用于测试：Spring + Mybatis注解的整合
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyBatisAutoConfiguration.class);
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        User user = new User();
        user.setName("annotation1");
        user.setPassword("1234567");
        userDAO.save(user);
    }

    /**
     * 用于测试：注解版 事务开发
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.liuxiaocs.mybatis");
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");
        User user = new User();
        user.setName("txAnnotation");
        user.setPassword("123456");
        userServiceImpl.register(user);
    }

    /**
     * 用于测试：YML
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(YmlAutoConfiguration.class);
        Account account = (Account) ctx.getBean("account");
        System.out.println("account.getName() = " + account.getName());
        System.out.println("account.getPassword() = " + account.getPassword());
        List<String> list = account.getList();
        for (String s : list) {
            System.out.println("s = " + s);
        }
    }
}
