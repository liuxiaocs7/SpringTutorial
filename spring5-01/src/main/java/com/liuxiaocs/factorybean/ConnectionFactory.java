package com.liuxiaocs.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 实例工厂
 */
public class ConnectionFactory {

    public Connection getConnection() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis-plus?serverTimezone=GMT%2B8", "root", "lx123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
