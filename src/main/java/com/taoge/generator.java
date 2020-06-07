package com.taoge;

import com.taoge.loc.*;
import org.springframework.cglib.beans.BeanGenerator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class generator {

//    public static void main(String[] args) {
//        BeanGenerator generator=new BeanGenerator();
//        generator.addProperty("cp",String.class);
//        Class aClass = generator.createClass().getClass();
//        Field[] fields=aClass.getDeclaredFields();
//        for(Field field:fields){
//            System.out.println(field.getName());
//        }
//        Method[] methods=aClass.getDeclaredMethods();
//        for(Method temp:methods){
//            System.out.println(temp.getName());
//        }
//    }

    public static void main(String[] args) {
        change(BaseLoc.class);
        change(PhoneLoc.class);
        change(PlateLoc.class);
        change(IdentityLoc.class);
        change(SocietyLoc.class);
    }


    public static void change(Class clazz){
        Field[] fields=clazz.getDeclaredFields();
        for(Field field:fields){
//            System.out.println(clazz.getSimpleName()+"."+field.getName()+"="+field.getName());
            System.out.println(field.getName()+"="+field.getName());
        }
    }


}
