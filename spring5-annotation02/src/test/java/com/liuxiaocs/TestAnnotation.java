package com.liuxiaocs;


import com.liuxiaocs.bean.Customer;
import com.liuxiaocs.bean.User;
import com.liuxiaocs.injection.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        // User user = (User ) ctx.getBean("user");
        // System.out.println("user = " + user);
        //
        // Connection conn = (Connection) ctx.getBean("conn");
        // System.out.println("conn = " + conn);
        //
        // Connection conn1 = (Connection) ctx.getBean("conn1");
        // System.out.println("conn1 = " + conn1);
    }

    /**
     * 用于测试：对象的创建次数
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User u = (User) ctx.getBean("u");
        User u1 = (User) ctx.getBean("u");

        System.out.println("u = " + u);
        System.out.println("u1 = " + u1);
    }

    /**
     * 用于测试：@Bean注解注入
     */
    @Test
    public void test4() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println("userService = " + userService);
        userService.register();
    }

    /**
     * 用于测试：@Bean JDK类型的注入
     */
    @Test
    public void test5() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer.getId() = " + customer.getId());
        System.out.println("customer.getName() = " + customer.getName());
    }

    /**
     * 用于测试：@ComponentScan基本使用方式
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }
}
