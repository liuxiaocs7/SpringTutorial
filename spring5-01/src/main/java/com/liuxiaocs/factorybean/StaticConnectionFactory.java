package com.liuxiaocs.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionFactory cf = new ConnectionFactory();
 * cf.getConnection();
 * 直接调用，避免了一步创建对象的过程
 * staticConnectionFactory.getConnection();
 *
 * 静态工厂
 *
 * @author liuxiaocs
 * @date 2021/3/17 11:13
 */
public class StaticConnectionFactory {

    public static Connection getConnection() {

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
