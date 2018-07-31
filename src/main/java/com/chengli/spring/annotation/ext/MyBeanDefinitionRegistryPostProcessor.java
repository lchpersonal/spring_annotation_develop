package com.chengli.spring.annotation.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: chengli
 * @Date: 2018/7/30 18:09
 *
 * BeanDefinitionRegistryPostProcessor继承于BeanFactoryPostProcessor，有一个自己的方法postProcessBeanDefinitionRegistry
 * 该方法会在BeanFactory标准初始化之后，所有Bean实例化之前【注意这里和postProcessBeanFactory的区别，一个是初始化之前，一个是实例化之前】
 * Bean是先实例化（即创建对象，分配内存，然后才会有初始化操作）。
 * 所以postProcessBeanDefinitionRegistry在postProcessBeanFactory之前执行
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry~~~~~~~~~~~~~~~~");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory~~~~~~~~~~~~~~~");
    }
}
