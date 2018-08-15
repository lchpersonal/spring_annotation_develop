package com.chengli.spring.annotation.lifecycle.env;

import com.chengli.spring.annotation.lifecycle.po.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: chengli
 * @Date: 2018/7/29 16:34
 * <p>
 * Bean的生命周期：
 * 1). 通过@Bean注解注册的Bean可以使用initMethod和destoryMethod来指定初始化和销毁方法
 * 在单实例情况下，init方法会在bean初始化完成后调用，destroy会在容器关闭的时候调用；
 * 在多实例情况下，init方法会在我们获取bean的时候调用，多实例的bean销毁操作，由我们自己来控制。
 * <p>
 * 2).通过让Bean实现InitializingBean接口来定义初始化，通过实现DisposableBean来定义销毁
 * 详细使用见:
 * @see com.chengli.spring.annotation.lifecycle.po.Cat
 * 3).通过@PostContructor和@PreDestory (JSR250规范的注解)
 * @see com.chengli.spring.annotation.lifecycle.po.Dog
 * <p>
 * 4).BeanPostProcessor接口，此接口的实现了不是注册类实例的，而是每个实例注册的过程中，都会调用此类的接口
 * postProcessBeforeInitialization在Bean实例化完成之后，在任何初始化方法调用之前执行
 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization
 * postProcessAfterInitialization 在bean初始化方法调用之后执行
 * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization
 */
@Configuration
@ComponentScan(basePackages = {"com.chengli.spring.annotation.lifecycle"})
public class LifeCycleConfig {

    @Bean(initMethod = "init", destroyMethod = "destory")
    public Car car() {
        return new Car();
    }


}
