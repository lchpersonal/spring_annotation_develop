package com.chengli.spring.annotation.autowire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: chengli
 * @Date: 2018/7/29 18:19
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
