package com.chengli.spring.annotation.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: chengli
 * @Date: 2018/7/30 16:41
 */
public class TxMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        TxDao txDao = applicationContext.getBean(TxDao.class);
        txDao.update();
    }
}
