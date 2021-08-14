package com.liuxiaocs;


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
}
