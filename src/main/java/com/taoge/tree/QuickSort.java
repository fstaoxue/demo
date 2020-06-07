package com.taoge.tree;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void quickSort(int[] data,int start,int end){
        if(start<end){
            int index=sort(data,start,end);
            quickSort(data,start,index);
            quickSort(data,index+1,end);
        }
    }

    public static int sort(int[] data,int start,int end){
        int left=start;
        int right=end;
        int key=data[start];
        while(left<right){
            while(left<right&&data[right]>=key){
                right--;
            }
            data[left]=data[right];
            while(left<right&&data[left]<=key){
                left++;
            }
            data[right]=data[left];
        }
        data[left]=key;
        return left;
    }

    public static void main(String[] args) {
        int number=1000;
        int[] data=new int[number];
        Random random=new Random();
        for(int i=0;i<number;i++){
            data[i]=random.nextInt(1000);
        }
        int[] copyData= Arrays.copyOf(data,number);
        System.out.println(Arrays.toString(data));
        quickSort(data,0,number-1);
        System.out.println(Arrays.toString(data));
        Arrays.sort(copyData);
        System.out.println(Arrays.toString(copyData));
        System.out.println(Arrays.equals(data,copyData));
    }

}
