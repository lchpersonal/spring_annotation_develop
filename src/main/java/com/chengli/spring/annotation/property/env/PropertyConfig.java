package com.chengli.spring.annotation.property.env;

import com.chengli.spring.annotation.property.po.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: chengli
 * @Date: 2018/7/29 17:53
 * 属性的赋值
 */
@Configuration
@PropertySource(value = {"classpath:/person.properties"},encoding = "utf-8")
public class PropertyConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
