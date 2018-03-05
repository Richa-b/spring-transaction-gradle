package com.demo;

import com.demo.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class TransactionMain {

    public static void main(String[] args) {
        // Add Main Method related Code here

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);
        AccountService accountService =(AccountService) applicationContext.getBean("accountService");
        accountService.insertIntoUserAccountUsingProgrammaticTransaction();
    }
}
