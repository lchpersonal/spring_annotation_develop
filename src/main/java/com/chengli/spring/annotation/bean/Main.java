package com.chengli.spring.annotation.develop;

import com.chengli.spring.annotation.develop.env.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: chengli
 * @Date: 2018/7/29 15:55
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
    }
}
