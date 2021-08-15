package com.liuxiaocs;

import com.liuxiaocs.bean.ConnectionFactoryBean;
import com.liuxiaocs.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    /**
     * 简单对象
     */
    @Bean("u")
    // @Scope("prototype")
    public User user() {
        return new User();
    }

    /**
     * 创建复杂对象
     * Connection 不能直接通过new 创建
     * 将创建连接对象的代码直接写过来即可
     */
    @Bean
    public Connection conn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/suns?serverTimezone=GMT%2B8", "root", "lx123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Bean
    public Connection conn1() {
        Connection conn = null;
        try {
            ConnectionFactoryBean factoryBean = new ConnectionFactoryBean();
            conn = factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
