package com.taoge.bean;

import java.util.concurrent.Callable;

public class MyTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "ss";
    }
}
