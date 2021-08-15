package com.liuxiaocs;


import com.liuxiaocs.aop.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotation1 {

    /**
     * 测试AOP
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.liuxiaocs.aop.AppConfig.class);
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");
        userServiceImpl.register();
        userServiceImpl.login();
    }
}
