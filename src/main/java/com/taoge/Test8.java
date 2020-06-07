package com.taoge;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test8 {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<Integer>(5);
        MyProducer producer=new MyProducer("producer",blockingQueue);
        MyConsumer consumer=new MyConsumer("consumer",blockingQueue);
        producer.start();
        consumer.start();
    }

}

class MyProducer extends Thread{
    private String name;
    private ArrayBlockingQueue<Integer> blockingQueue;
    public MyProducer(String name,ArrayBlockingQueue<Integer> blockingQueue){
        this.name=name;
        this.blockingQueue=blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            if(blockingQueue.size()>0){
                System.out.println("已经存在数据了");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    int temp=new Random().nextInt(1000);
                    boolean result=blockingQueue.offer(temp,1, TimeUnit.SECONDS);
                    if(result){
                        System.out.println(name+"-->"+temp);
                    }else{
                        System.out.println("已经满了");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyConsumer extends Thread{
    private String name;
    private ArrayBlockingQueue<Integer> blockingQueue;
    public MyConsumer(String name,ArrayBlockingQueue<Integer> blockingQueue){
        this.name=name;
        this.blockingQueue=blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Integer result=blockingQueue.poll(1,TimeUnit.SECONDS);
                if(result!=null){
                    System.out.println(name+"-->"+result);
                }else{
                    System.out.println("已经没有数据了");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
