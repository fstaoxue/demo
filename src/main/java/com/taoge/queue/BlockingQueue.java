package com.taoge.queue;

public interface BlockingQueue {

    String take();

    void put(String ele);
}
