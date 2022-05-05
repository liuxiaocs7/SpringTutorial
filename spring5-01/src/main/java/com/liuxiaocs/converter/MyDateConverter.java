package com.liuxiaocs.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期类型转换器
 * Converter<String, Date> 原始转换类型和目标转换类型
 */
public class MyDateConverter implements Converter<String, Date> {

    /**
     * 自定义转换器依赖于日期字符串的格式，抽离出来，通过Spring进行注入
     * 即可以在配置文件中自定义转换格式
     */
    private String pattern;

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * convert方法作用：String ---> Date
     *                  SimpleDateFormat sdf = new SimpleDateFormat();
     *                  sdf.parse(String) ---> Date
     *
     * 问题：
     * 1. 如何获取Spring配置文件中的原始输入字符串呢？
     * param: source 代表的是配置文件中的日期字符串 <value>2020-10-11</value>
     * 2. 转换好了之后如何交给Product中的成员变量进行赋值呢？
     * return: 当把转换好的Date作为convert方法的返回值后，Spring自动地为birthday属性进行注入(赋值)
     *
     */
    public Date convert(String source) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
