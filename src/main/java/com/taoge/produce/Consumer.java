package com.taoge.produce;

public class Consumer implements Runnable {

    private int[] data;
    public Consumer(int[] data){
        this.data=data;
    }


    @Override
    public void run() {
        synchronized (data){
            if(data.length==0){
                try {
                    data.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
