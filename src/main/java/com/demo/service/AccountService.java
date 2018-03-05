package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;


@Component
public class AccountService {


    @Autowired
    JdbcTemplate jdbcTemplate;


    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    LoggingService loggingService;


    @Transactional(propagation = Propagation.REQUIRED)
    public void insertEmployee() {
        System.out.println("Inserting into table");
        String sql = "INSERT INTO user_account (username,amount)VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{"Peter", 2700});
        try {
            loggingService.loggingIntoTransactionTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


   /* @Transactional(propagation = Propagation.REQUIRED)
    public void insertEmployee1() throws Exception {
        System.out.println("Inserting into table");
        String sql = "INSERT INTO user_account (username,amount)VALUES(?,?)";
        jdbcTemplate.update(sql, new Object[]{"Peter", 2700});
        for (int i = 0; i < 3; i++) {
            loggingService.loggingIntoTransactionTable1();
        }
        throw new Exception();

    }*/
}
