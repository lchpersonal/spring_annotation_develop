package com.chengli.spring.annotation.property;

import com.chengli.spring.annotation.property.env.PropertyConfig;
import com.chengli.spring.annotation.property.po.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: chengli
 * @Date: 2018/7/29 18:01
 */
public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertyConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);


    }
}
