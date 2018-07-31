package com.chengli.spring.annotation.transaction;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Author: chengli
 * @Date: 2018/7/30 15:52
 * 声明式事务：
 * 1. 导入jar包 spring-jdbc
 * 2. 准备数据库表：
 * <pre>
 *   CREATE TABLE `user` (
 * 	  `id` INT(11) NOT NULL AUTO_INCREMENT,
 * 	  `name` VARCHAR(20) NULL DEFAULT NULL,
 * 	  `age` INT(11) NULL DEFAULT NULL,
 * 	  PRIMARY KEY (`id`)
 *   ) ENGINE=MyISAM;
 * </pre>
 * 3. 配置数据源 datasource
 * 4.配置事务管理器PlatformTransactionManager【DataSourceTransactionManager】
 * 5.@EnableTransactionManagement
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.chengli.spring.annotation.transaction"})
public class TxConfig {

    @Bean(name = "dataSource")
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    @Bean
    public JdbcTemplate createTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager createDataSourceTransactionManagement(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}

