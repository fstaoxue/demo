package com.taoge.bloomfilter;

public class IntMap {

    private int[] data;

    private long maxValue;

    public IntMap(int maxValue){
        this.maxValue=maxValue;
        data=new int[maxValue/32];
    }

    public void add(int n){
        int num=n/32;
        int c=n%32;
        data[num]=data[num]|(1<<c);
    }

    public void remove(int n){
        int num=n/32;
        int c=n%32;
        data[num]&=~(1<<c);
    }

    public boolean contains(int n){
        int num=n/32;
        int c=n%32;
        return ((data[num]>>>c)&1)==1;
    }


}
