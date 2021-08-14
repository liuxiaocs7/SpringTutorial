package com.liuxiaocs;

import com.liuxiaocs.injection.UserDAO;
import com.liuxiaocs.injection.UserDAOImpl;
import com.liuxiaocs.injection.UserService;
import com.liuxiaocs.injection.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }

    // 方式1
    // @Bean
    // public UserService userService(UserDAO userDAO) {
    //     UserServiceImpl userService = new UserServiceImpl();
    //     userService.setUserDAO(userDAO);
    //     return userService;
    // }

    // 方式2：简化写法
    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDAO(userDAO());
        return userService;
    }
}
