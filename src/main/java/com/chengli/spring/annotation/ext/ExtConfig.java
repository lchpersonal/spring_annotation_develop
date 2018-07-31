package com.chengli.spring.annotation.ext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: chengli
 * @Date: 2018/7/30 17:33
 * 1. BeanFactoryPostProcessor
 * @see com.chengli.spring.annotation.ext.MyBeanFactoryPostProcessor
 * <p>
 * 2. BeanDefinitionRegistryPostProcessor
 *  BeanDefinitionRegistryPostProcessor接口继承于BeanFactoryPostProcessor
 */

@ComponentScan(basePackages = {"com.chengli.spring.annotation.ext"})
@Configuration
public class ExtConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

    }
}
