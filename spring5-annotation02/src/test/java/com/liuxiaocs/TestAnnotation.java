package com.liuxiaocs;


import com.liuxiaocs.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

public class TestAnnotation {
    /**
     * 用于测试：配置Bean
     */
    @Test
    public void test1() {
        // 1. 指定配置bean所在的类
        // ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        // 2. 指定配置bean所在的包
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.liuxiaocs");
    }

    /**
     * 用于测试：@Bean注解
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = (User ) ctx.getBean("user");
        System.out.println("user = " + user);

        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);

        Connection conn1 = (Connection) ctx.getBean("conn1");
        System.out.println("conn1 = " + conn1);
    }
}
