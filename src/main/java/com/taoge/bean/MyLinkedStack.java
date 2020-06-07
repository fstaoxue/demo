package com.taoge.bean;

public class MyLinkedStack<T> implements Stack<T> {

    private Node index;

    public class Node{
        private T ele;
        private Node pre;
        private Node next;
        public Node(){}
        public Node(T e){
            this.ele=e;
            this.next=null;
        }
    }

    @Override
    public T pop() {
        T ele=index.ele;
        index=index.pre;
        return ele;
    }

    @Override
    public void push(T a) {
        Node temp=new Node(a);
        if(index==null){
            index=temp;
        }else{
            index.next=temp;
            temp.pre=index;
            index=temp;
        }
    }

    @Override
    public void grow() {

    }
}
