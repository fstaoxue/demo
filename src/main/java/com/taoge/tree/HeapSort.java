package com.taoge.tree;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

    public static void  heapSort(int[] data,int length){
        int lastLeafNode=length/2-1;
        for(int i=lastLeafNode;i>=0;i--){
            boolean hasLeft=false;
            boolean hasRight=false;
            int cur=data[i];
            int left=0,right=0;
            if((2*i+1)<length){
                hasLeft=true;
                left=data[2*i+1];
            }
            if((2*i+2)<length){
                hasRight=true;
                right=data[2*i+2];
            }
            if(!hasLeft&&!hasRight){
                continue;
            }
            if(hasLeft&&!hasRight){
                if(cur<left){
                    int temp=data[i];
                    data[i]=data[2*i+1];
                    data[2*i+1]=temp;
                    heapSort(data,length);
                }
            }
            if(hasRight&&!hasLeft){
                if(cur<right){
                    int temp=data[i];
                    data[i]=data[2*i+2];
                    data[2*i+2]=temp;
                    heapSort(data,length);
                }
            }
            if(hasLeft&&hasRight){
                if(cur<left&&left>right){
                    int temp=data[i];
                    data[i]=data[2*i+1];
                    data[2*i+1]=temp;
                    heapSort(data,length);
                }
                if(cur<right&&right>=left){
                    int temp=data[i];
                    data[i]=data[2*i+2];
                    data[2*i+2]=temp;
                    heapSort(data,length);
                }
            }
        }
    }

    public static void main(String[] args) {
        int number=1000;
        int[] data=new int[number];
        Random random=new Random();
        for(int i=0;i<number;i++){
            data[i]=random.nextInt(1000);
        }
        int[] copyData=Arrays.copyOf(data,number);
        System.out.println(Arrays.toString(data));
        for(int i=0;i<number;i++){
            heapSort(data,number-i);
            int temp=data[0];
            data[0]=data[number-1-i];
            data[number-1-i]=temp;
        }
        System.out.println(Arrays.toString(data));
        Arrays.sort(copyData);
        System.out.println(Arrays.toString(copyData));
        System.out.println(Arrays.equals(data,copyData));
    }

}
