package com.liuxiaocs.basic;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 通过工厂来创建对象
 *
 * @author liuxiaocs
 * @date 2021/3/16 20:08
 */
public class Person {

    private Integer id;
    private String name;

    private String[] emails;

    private Set<String> tels;

    private List<String> addresses;

    private Map<String, String> qqs;

    private Properties p;

//    private Person() {
//        System.out.println("Person.Person");
//    }

    public Person() {
        System.out.println("Person.Person");
    }

    public Properties getP() {
        return p;
    }

    public void setP(Properties p) {
        this.p = p;
    }

    public Map<String, String> getQqs() {
        return qqs;
    }

    public void setQqs(Map<String, String> qqs) {
        this.qqs = qqs;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getTels() {
        return tels;
    }

    public void setTels(Set<String> tels) {
        this.tels = tels;
    }

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
