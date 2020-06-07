package com.taoge;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test6 {

    public static void main(String[] args) {
        int count=5;
        CyclicBarrier barrier=new CyclicBarrier(count);
        for(int i=0;i<count;i++){
            new ThreadF("p"+i,barrier).start();
        }
    }
}

class ThreadF extends Thread{
    private String name;
    private CyclicBarrier cyclicBarrier;
    public ThreadF(String name,CyclicBarrier barrier){
        this.name=name;
        this.cyclicBarrier=barrier;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(100));
            System.out.println(name+"start write");
            Thread.sleep(new Random().nextInt(100));
            System.out.println(name+"end write");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("all write");
    }
}