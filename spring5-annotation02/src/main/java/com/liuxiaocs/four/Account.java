package com.liuxiaocs.four;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
// 方式二
// @PropertySource("classpath:four.properties")
public class Account implements Serializable {

    @Value("${id}")
    private Integer id;
    @Value("${name}")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
