package com.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoggingService {

    @Autowired
    JdbcTemplate jdbcTemplate;

   /* @Transactional(propagation = Propagation.REQUIRED)
    public void loggingIntoTransactionTable() {
    System.out.println("In Required");
        throw new RuntimeException();
    }
*/

   /* @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void loggingIntoTransactionTable() {
    System.out.println("In Requires New");
        throw new RuntimeException();
    }*/

   /* @Transactional(propagation = Propagation.MANDATORY)
    public void loggingIntoTransactionTable() {
        System.out.println("In Mandatory");
    }*/

    /*@Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void loggingIntoTransactionTable() {
        String sql = "INSERT into log (from_user,to_user,amount) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{1, 2, 2000});

        System.out.println("In Not Supported ");
        throw new RuntimeException();
    }*/


  /*  @Transactional(propagation = Propagation.SUPPORTS)
    public void loggingIntoTransactionTable() {
        String sql = "INSERT into log (from_user,to_user,amount) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{1, 2, 2000});

        System.out.println("In Supports");
        throw new RuntimeException();
    }*/


    @Transactional(propagation = Propagation.NEVER)
    public void loggingIntoTransactionTable() {
        String sql = "INSERT into log (from_user,to_user,amount) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{1, 2, 2000});
        System.out.println("In Supports");
        throw new RuntimeException();
    }

  /* @Transactional(propagation = Propagation.NESTED)
    public void loggingIntoTransactionTable1() {
        String sql = "INSERT into log (from_user,to_user,amount) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{1, 2, 2000});
        System.out.println("In Nested");
    }*/

}
