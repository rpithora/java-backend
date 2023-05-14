package com.shreya.thread;

public class ThreadDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread : " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        System.out.println("Main Thread : " + Thread.currentThread().getName());

        ThreadDemo threadDemo1 = new ThreadDemo();
        Thread t1 = new Thread(threadDemo1, "T1");
        t1.start();

        Runnable threadDemo2 = new ThreadDemo();
        Thread t2 = new Thread(threadDemo2, "T2");
        t2.start();

        Runnable threadDemo3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Thread : " + Thread.currentThread().getName());
            }
        };

        Thread t3 = new Thread(threadDemo3, "T3");
        t3.start();

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Thread : " + Thread.currentThread().getName());
            }
        }, "T4");
        t4.start();

        Thread t5 = new Thread(() -> {
            System.out.println("Lambda Thread : " + Thread.currentThread().getName());
        },"T5");
        t5.start();
    }
}
