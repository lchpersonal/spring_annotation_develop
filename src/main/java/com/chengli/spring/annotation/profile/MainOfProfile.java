package com.chengli.spring.annotation.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: chengli
 * @Date: 2018/7/29 18:59
 * <p>
 * @Profile 根据当前环境来激活一系列不同组件的功能
 * @see com.chengli.spring.annotation.profile.ProfileConfig
 * 只有当Profile符合条件时，对应的实例才会被注册，默认注册value=default的实例
 * 指定实例的方法：
 * 1. jvm参数：-Dspring.prifiles.active=dev
 * 2. 代码指定
 * @see com.chengli.spring.annotation.profile.MainOfProfile#main(String[])
 * <p>
 * 当@Profile标注在类上时，不满足条件时，整个类中的所有信息（包括没有@Profile标注的）都不会被加载。
 * 没有标注@Profile注解的Bean，在任何@Profile条件下环境下（除了@Profile标注在类上）都是加载的
 */
public class MainOfProfile {

    public static void main(String[] args) {
        /**
         * 必须使用无参数的构造器，因为使用有参数的构造器，容器就会直接初始化完毕了。
         */
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("dev");
        applicationContext.register(ProfileConfig.class);
        applicationContext.refresh();
        ProfileData profileData = applicationContext.getBean(ProfileData.class);
        System.out.println(profileData);
    }
}
