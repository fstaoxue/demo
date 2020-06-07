package com.taoge;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Test7 {

    public static void main(String[] args) {
        int count=10;
        CountDownLatch latch=new CountDownLatch(count);
        for(int i=0;i<count;i++){
            new ThreadG("p"+i,latch).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("全部执行完毕");
    }
}

class ThreadG extends Thread{

    private CountDownLatch latch;

    private String name;

    public ThreadG(String name,CountDownLatch latch){
        this.name=name;
        this.latch=latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(name+"start execute");
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(name+"end execute");
            latch.countDown();
        }
    }
}
