package com.taoge;

import java.util.Random;

public class Test5 {

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> local=new ThreadLocal<>();
        ThreadE p1=new ThreadE("p1",local);
        ThreadE p2=new ThreadE("p2",local);
        ThreadE p3=new ThreadE("p3",local);
        p1.start();
        p2.start();
        p3.start();
        p1.join();
        p2.join();
        p3.join();
        System.out.println(local);
    }
}

class ThreadE extends Thread{
    private ThreadLocal<Integer> local;
    private String name;

    public ThreadE(String name,ThreadLocal<Integer> local){
        this.name=name;
        this.local=local;
    }
    @Override
    public void run() {
        while(true){
            if(local.get()==null){
                local.set(0);
            }
            int count=local.get();
            System.out.println(name+"-->"+count);
            local.set(count+1);
            if(count>10){
                break;
            }
            try {
                Thread.sleep(new Random().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
