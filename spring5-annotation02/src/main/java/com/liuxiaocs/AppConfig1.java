package com.liuxiaocs;

import com.liuxiaocs.bean.Customer;
import com.liuxiaocs.injection.UserDAO;
import com.liuxiaocs.injection.UserDAOImpl;
import com.liuxiaocs.injection.UserService;
import com.liuxiaocs.injection.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/init.properties")
public class AppConfig1 {

    @Value("${id}")
    private Integer id;

    @Value("${name}")
    private String name;

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

    // @Bean
    // public Customer customer() {
    //     Customer customer = new Customer();
    //     customer.setId(1);
    //     customer.setName("xiaohei");
    //     return customer;
    // }

    @Bean
    public Customer customer() {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        return customer;
    }
}
