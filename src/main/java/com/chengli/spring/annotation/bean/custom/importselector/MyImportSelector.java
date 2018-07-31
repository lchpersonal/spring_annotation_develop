package com.chengli.spring.annotation.develop.custom.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: chengli
 * @Date: 2018/7/29 15:44
 */
public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.chengli.spring.annotation.develop.service.Yellow"};
    }
}
