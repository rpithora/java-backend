package com.shreya.designpattern.singleton;

public class Singleton {

    private static Singleton INSTANCE;

    private Singleton() {
    }

    public void print() {
        System.out.println("Object Id : " + this);
    }

    public static Singleton getInstance() {
        if (null == INSTANCE) {
            synchronized (Singleton.class) {
                if (null == INSTANCE)
                    INSTANCE = new Singleton();
                return INSTANCE;
            }
        }
        return INSTANCE;
    }
}
