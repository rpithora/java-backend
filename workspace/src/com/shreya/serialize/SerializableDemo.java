package com.shreya.serialize;

import java.io.*;

public class SerializableDemo implements Serializable {
    transient static String clg = "CLG";
    transient final int dob = 10;
    transient double mobileNo = 8050912654l;
    private int id = 100;
    private String name = "Serializable";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("SerializableDemo.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        SerializableDemo serializableDemo = new SerializableDemo();
        System.out.println("serializableDemo.id : " + serializableDemo.id);
        System.out.println("serializableDemo.name : " + serializableDemo.name);
        System.out.println("serializableDemo.mobileNo : " + serializableDemo.mobileNo);
        System.out.println("serializableDemo.dob : " + serializableDemo.dob);
        System.out.println("serializableDemo.clg : " + serializableDemo.clg);
        System.out.println("serializableDemo : " + serializableDemo);
        objectOutputStream.writeObject(serializableDemo);

        FileInputStream fileInputStream = new FileInputStream("SerializableDemo.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SerializableDemo ser = (SerializableDemo) objectInputStream.readObject();
        System.out.println("serializableDemo.id : " + ser.id);
        System.out.println("serializableDemo.name : " + ser.name);
        System.out.println("serializableDemo.mobileNo : " + ser.mobileNo);
        System.out.println("serializableDemo.dob : " + ser.dob);
        System.out.println("serializableDemo.clg : " + ser.clg);
        System.out.println("serializableDemo : " + ser);
    }

}
