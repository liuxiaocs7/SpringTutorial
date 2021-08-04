package com.liuxiaocs.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 复杂对象的创建方式
 * 实现 FactoryBean<T> 接口
 * 泛型表达了要创建什么类型的复杂对象
 *
 * @author liuxiaocs
 * @date 2021/3/17 10:25
 */
public class ConnectionFactoryBean implements FactoryBean<Connection> {

    // 需要以下四个内容，将这些内容定义为成员变量，也就是依赖
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 用于书写创建复杂对象的代码并把复杂对象作为方法的返回值返回
    // 引入的泛型决定了返回的内容
    public Connection getObject() throws Exception {

        // 依赖，耦合度较高
        Class.forName(driverClassName);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    // 返回所创建复杂对象的Class对象
    public Class<?> getObjectType() {
        return Connection.class;
    }

    // 只需要创建一次：true
    // 每一次调用都需要创建一个新的复杂对象：false
    public boolean isSingleton() {
        return false;
        // return true;
    }
}
