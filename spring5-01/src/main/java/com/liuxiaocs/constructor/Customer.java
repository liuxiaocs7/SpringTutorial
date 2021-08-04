package com.liuxiaocs.constructor;

import java.io.Serializable;

/**
 * 测试构造器注入
 *
 * @author liuxiaocs
 * @date 2021/3/16 23:28
 */
public class Customer implements Serializable {

    private String name;
    private int age;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(int age) {
        this.age = age;
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


