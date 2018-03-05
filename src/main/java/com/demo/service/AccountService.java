package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.SQLException;


@Component
public class AccountService {


    @Autowired
    JdbcTemplate jdbcTemplate;


    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    LoggingService loggingService;


    public void insertIntoUserAccountUsingProgrammaticTransaction() {
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

        System.out.println("Inserting into table Programmatic");
        try {
            String sql = "INSERT INTO user_account (username,amount)VALUES(?,?)";
            jdbcTemplate.update(sql, new Object[]{"Peter", 2700});
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
        }
        transactionManager.commit(transactionStatus);

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertIntoUserAccount() {
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
