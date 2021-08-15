package com.liuxiaocs;


import com.liuxiaocs.mybatis.MyBatisAutoConfiguration;
import com.liuxiaocs.mybatis.User;
import com.liuxiaocs.mybatis.UserDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
}
