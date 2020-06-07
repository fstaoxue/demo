package com.taoge.atom;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtom {

    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger();
        atomicInteger.incrementAndGet();
    }
}
