package com.chengli.spring.annotation.property.po;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: chengli
 * @Date: 2018/7/29 17:55
 */

public class Person {

    @Value("张三")
    private String name;

    //SPEL表达式
    @Value("#{20-2}")
    private int age;

    /**从配置文件中进行属性赋值，相当于是从Envirement*/
    @Value("${person.nickName}")
    private String nickName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
