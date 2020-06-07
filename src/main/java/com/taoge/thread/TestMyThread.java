package com.taoge.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestMyThread implements Runnable{

    public volatile AtomicInteger count=new AtomicInteger();

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            count.incrementAndGet();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(count.get());
        }
    }

    public static void main(String[] args) {
        ThreadGroup group=new ThreadGroup("count");
        TestMyThread myThread=new TestMyThread();
        for(int i=0;i<10;i++){
            new Thread(group,myThread).start();
        }
        while(group.activeCount()>0){
            System.out.println(group.activeCount());
        }
    }
}
