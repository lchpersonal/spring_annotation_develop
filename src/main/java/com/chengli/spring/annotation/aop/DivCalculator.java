package com.chengli.spring.annotation.aop;

import org.springframework.stereotype.Component;

/**
 * @Author: chengli
 * @Date: 2018/7/29 23:34
 * 除法计算器
 */
@Component
public class DivCalculator {

    public double div(double a, double b) {
        System.out.println("div calculator~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return a / b;
    }
}
