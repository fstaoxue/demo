package com.taoge.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;
import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        Random random=new Random();
        int age=random.nextInt(20)+10;
        String name= UUID.randomUUID().toString().substring(0,5);
        String sql="insert into user(username,age) values('"+name+"',"+age+")";
        jdbcTemplate.execute(sql);
    }
}
