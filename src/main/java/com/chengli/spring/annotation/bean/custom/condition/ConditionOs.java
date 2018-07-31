package com.chengli.spring.annotation.bean.custom.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: chengli
 * @Date: 2018/7/29 15:29
 */
public class ConditionOs implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("os.name");
        if(property.contains("Windows")){
            return true;
        }
        return false;
    }
}
