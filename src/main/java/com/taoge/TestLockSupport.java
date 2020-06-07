package com.taoge;

import java.util.concurrent.locks.LockSupport;

public class TestLockSupport {

    public static void main(String[] args) throws InterruptedException {
        Thread temp=new Thread(new Thread11());
        temp.start();
        Thread.sleep(5000);
        LockSupport.unpark(temp);
    }
}


class Thread11 implements Runnable{


    @Override
    public void run() {
        System.out.println("1111");
        LockSupport.park();
        System.out.println("loslos");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ziziziizzii");
    }
}
