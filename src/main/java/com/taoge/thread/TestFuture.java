package com.taoge.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestFuture {

    public static void main(String[] args){
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        List<Future<Integer>> futureList=new ArrayList<>();
        for(int i=0;i<1000;i++){
            Future<Integer> submit = executorService.submit(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    return 10;
                }
            });
            futureList.add(submit);
        }
        executorService.shutdown();
        while(true){
            if(executorService.isTerminated()){
                break;
            }
        }
        List<Integer> rr=new ArrayList<>();
        for(Future<Integer> temp:futureList){
            try {
                rr.add(temp.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(rr.size());

    }

}
