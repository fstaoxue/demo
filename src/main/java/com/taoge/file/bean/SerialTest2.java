package com.taoge.file.bean;

import java.io.*;

public class SerialTest2 extends SerialTest  implements Externalizable{

    private String name;

    private String idCard;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(idCard);
        System.out.println("write external");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name=(String)in.readObject();
        idCard=(String)in.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(new File("D:\\xyz.txt")));
        SerialTest2 test2=new SerialTest2();
        test2.setName("weimeng");
        test2.setIdCard("sajss");

        outputStream.writeObject(test2);
        outputStream.close();
        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(new File("D:\\xyz.txt")));
        SerialTest2 test3=(SerialTest2) inputStream.readObject();
        System.out.println(test3.toString());
        inputStream.close();

    }

    @Override
    public String toString() {
        return "SerialTest2{" +
                "name='" + name + '\'' +

                ", idCard='" + idCard + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
