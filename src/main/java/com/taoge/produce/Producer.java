package com.taoge.produce;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

    private int[] data;

    private int count;
    public Producer(int[] data){
        this.data=data;
        count=0;
    }

    @Override
    public void run() {
        synchronized (data){
            if(data.length-1==count){
                try {
                    data.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int temp=new Random().nextInt(1000);
            data[count]=temp;
            count++;
            if(data.length==1){
                data.notify();
            }
        }

    }
}
