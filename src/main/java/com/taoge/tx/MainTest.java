package com.taoge.tx;

import com.taoge.tx.config.TxConfig;
import com.taoge.tx.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.taoge.tx");
//        UserService userService=applicationContext.getBean(UserService.class);
//        userService.insert();
    }
}
