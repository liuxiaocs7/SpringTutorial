package com.liuxiaocs;

import com.liuxiaocs.injection.UserDAO;
import com.liuxiaocs.injection.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ImportResource("applicationContext.xml")
public class AppConfig4 {

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }
}
