package com.shreya.thread;

public class Deadlock {
    public static void main(String[] args) {

        String resource1 = new String("Resource1");
        String resource2 = new String("Resource2");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1){
                    System.out.println("Thread 1: locked resource 1");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 1: Going to acquire lock on resource 2");
                    synchronized (resource2){
                        System.out.println("Thread 1: locked resource 2");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2){
                    System.out.println("Thread 2: locked resource 2");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 2: Going to acquire lock on resource 1");
                    synchronized (resource1){
                        System.out.println("Thread 2: locked resource 1");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
