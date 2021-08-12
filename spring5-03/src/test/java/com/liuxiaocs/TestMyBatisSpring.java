package com.liuxiaocs;


import com.liuxiaocs.dao.UserDAO;
import com.liuxiaocs.entity.User;
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
}
