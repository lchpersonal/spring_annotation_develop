package com.chengli.spring.annotation.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: chengli
 * @Date: 2018/7/30 17:37
 * postProcessBeanFactory会在BeanFactory标注初始化之后，运行。
 * 所谓标准初始化指的是，所有的Bean定义已经注册，但是还没有Bean被初始化
 * <p>
 * 运行可以看到postProcessBeanFactory方法先执行，ExtColor的构造方法后执行
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("this is MyBeanFactoryPostProcessor,beanDefinitionNames 数量：" + beanDefinitionNames.length);
     /*   for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }*/
    }
}
