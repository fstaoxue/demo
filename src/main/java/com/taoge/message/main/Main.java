package com.taoge.message.main;

import com.taoge.bean.LocInfo;
import com.taoge.message.bean.MessageConfiguration;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MessageConfiguration.class);
//        Object[] param=new Object[]{"ll"};
//        System.out.println(applicationContext.getMessage("name",param, Locale.CHINA));

        LocInfo loc=new LocInfo();
        loc.setCp(10000);
        loc.setLat(12.03);
        loc.setLng(32.36);
        loc.setInfo("13900000000");
        LocInfo loc2=new LocInfo();
        BeanUtils.copyProperties(loc,loc2);
        loc2.setInfo("18900000000");
        System.out.println(loc2.toString());
        System.out.println(loc.toString());
    }
}
