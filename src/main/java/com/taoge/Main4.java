package com.taoge;

import java.util.Optional;

public class Main4 {

    public static void main(String[] args) {

        String name=null;
        Optional.ofNullable(name).ifPresent(ele->{
            System.out.println(ele);
        });



    }
}
