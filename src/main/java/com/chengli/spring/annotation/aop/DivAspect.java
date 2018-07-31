package com.chengli.spring.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: chengli
 * @Date: 2018/7/29 23:35
 */

@Aspect
@Component
public class DivAspect {

    /**
     * 抽取公共的切入点
     * public double com.chengli.spring.annotation.aop.DivCalculator.*(..)
     */
    @Pointcut("execution(public double com.chengli.spring.annotation.aop.DivCalculator.div(..))")
    public void pointCut() {
    }

    /**
     *
     * @param joinPoint 此参数必须在参数表的第一位，否则不能正常运行
     */
    @Before("pointCut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("@Before~"+ Arrays.asList(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("@After");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("@AfterReturning: " + result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logThrown(Exception exception) {
        System.out.println("@AfterThrowing: "+ exception.toString());
    }

   /* @Around("pointCut()")
    public void around() {
        System.out.println("around");
    }*/
}
