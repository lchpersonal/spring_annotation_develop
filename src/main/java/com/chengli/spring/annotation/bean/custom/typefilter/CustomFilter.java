package com.chengli.spring.annotation.develop.custom.typefilter;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Author: chengli
 * @Date: 2018/7/29 16:05
 */
public class CustomFilter implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        String className = metadataReader.getClassMetadata().getClassName();
        if (className.contains("ok")) {
            return true;
        }
        return false;
    }
}
