package com.liuxiaocs.config;

import com.liuxiaocs.injection.UserDAO;
import com.liuxiaocs.injection.UserService;
import com.liuxiaocs.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig2.class)
public class AppConfig1 {

    // 如何注入AppConfig2中创建的UserDAO对象
    // 直接添加@Autowired注解，将AppConfig2中创建的DAO对象注入给了AppConfig1
    @Autowired
    private UserDAO userDAO;

    // @Bean
    // public UserService userService() {
    //     UserService userService = new UserServiceImpl();
    //     return userService;
    // }

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDAO(userDAO);
        return userService;
    }
}
