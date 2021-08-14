package com.liuxiaocs.config;

import com.liuxiaocs.injection.UserService;
import com.liuxiaocs.injection.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig2.class)
public class AppConfig1 {

    @Bean
    public UserService userService() {
        UserService userService = new UserServiceImpl();
        return userService;
    }
}
