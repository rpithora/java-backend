package com.shreya.designpattern.creational.singleton;

public class Singleton {

    //private static Singleton INSTANCE = new Singleton();
    private static Singleton INSTANCE = null;

    private Singleton() {
    }

    public void print() {
        System.out.println("Object Id : " + this);
    }

    /*public synchronized static Singleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }*/

    public static Singleton getInstance() {
        if (null == INSTANCE) {
            synchronized (Singleton.class) {
                if (null == INSTANCE) INSTANCE = new Singleton();
                return INSTANCE;
            }
        }
        return INSTANCE;
    }
}
