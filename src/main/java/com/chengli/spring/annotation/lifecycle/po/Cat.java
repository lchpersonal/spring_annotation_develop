package com.chengli.spring.annotation.lifecycle.po;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author: chengli
 * @Date: 2018/7/29 16:44
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat construtor~~~");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat destory~~~");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat init~~");
    }
}
