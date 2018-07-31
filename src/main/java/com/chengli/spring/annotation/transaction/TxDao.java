package com.chengli.spring.annotation.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Author: chengli
 * @Date: 2018/7/30 16:33
 */
@Repository
public class TxDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void update(){
        String sql = "insert into user(name,age) values(?,?)";
        String name =  UUID.randomUUID().toString().substring(0,5);
        jdbcTemplate.update(sql,name,20);
        //这里抛异常，事务会回滚
        int i = 10/0;

    }
}
