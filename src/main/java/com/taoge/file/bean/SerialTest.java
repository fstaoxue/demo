package com.taoge.file.bean;

import java.io.*;

public class SerialTest  {

    private String name1;

    private int age1;

    private static int count=10;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(new File("D:\\xyz.txt")));
        SerialTest test=new SerialTest();
        test.setName1("taoge");
        test.setAge1(12);
        outputStream.writeObject(test);
        outputStream.close();
        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(new File("D:\\xyz.txt")));
        SerialTest test2=(SerialTest) inputStream.readObject();
        System.out.println(test2.toString());
        inputStream.close();
    }

    private void writeObject(ObjectOutputStream out){
        System.out.println("write object");
        try {
            out.defaultWriteObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("Read object");
        in.defaultReadObject();
        //idCard="sosososo";
        ObjectInputStream.GetField getField = in.readFields();
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public int getAge1() {
        return age1;
    }

    public void setAge1(int age1) {
        this.age1 = age1;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        SerialTest.count = count;
    }
}
