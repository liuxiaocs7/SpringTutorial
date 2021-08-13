package com.liuxiaocs;


import com.liuxiaocs.dao.UserDAO;
import com.liuxiaocs.entity.User;
import com.liuxiaocs.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyBatisSpring {

    /**
     * 用于测试：Spring与Mybatis的整合
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 接口首字母小写
        UserDAO userDao = (UserDAO) ctx.getBean("userDAO");

        User user = new User();
        user.setName("xiaojr");
        user.setPassword("999999");

        userDao.save(user);
    }

    /**
     * 用于测试：Spring的事务处理
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 通过原始对象的id值获取代理对象
        UserService userService = (UserService) ctx.getBean("userService");
        User user = new User();
        user.setName("xiaowb");
        user.setPassword("989898");
        userService.register(user);
    }
}
