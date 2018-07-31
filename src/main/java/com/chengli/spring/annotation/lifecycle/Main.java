package com.chengli.spring.annotation.lifecycle;

import com.chengli.spring.annotation.lifecycle.env.LifeCycleConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: chengli
 * @Date: 2018/7/29 17:06
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

    }
}
