package com.shreya.designpattern.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        //Singleton singleton = new Singleton();
        Singleton singleton = Singleton.getInstance();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                singleton.print();
            }
        });
        Thread thread2 = new Thread(() ->{
                singleton.print();
        });
        thread1.start();
        thread2.start();
    }
}
