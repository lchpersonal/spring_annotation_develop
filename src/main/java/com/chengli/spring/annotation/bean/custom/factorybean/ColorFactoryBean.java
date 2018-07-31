package com.chengli.spring.annotation.develop.custom.factorybean;

import com.chengli.spring.annotation.develop.service.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: chengli
 * @Date: 2018/7/29 16:09
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
