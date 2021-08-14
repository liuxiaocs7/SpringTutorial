package com.liuxiaocs.bean;


import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryBean implements FactoryBean<Connection> {
    @Override
    public Connection getObject() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/suns?serverTimezone=GMT%2B8", "root", "lx123456");
        return conn;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
