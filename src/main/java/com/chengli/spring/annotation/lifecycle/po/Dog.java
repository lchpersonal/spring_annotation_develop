package com.chengli.spring.annotation.lifecycle.po;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: chengli
 * @Date: 2018/7/29 16:51
 */
@Component
public class Dog {
    public Dog() {
        System.out.println("dog constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destory(){
        System.out.println("destory");
    }
}
