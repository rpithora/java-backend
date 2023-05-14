package com.shreya.thread;

public class ObjectLock implements Runnable{

    public static void main(String[] args) {
        ObjectLock objectLock1 = new ObjectLock();
        Thread t1 = new Thread(objectLock1,"T1");
        Thread t2 = new Thread(objectLock1,"T2");

        ObjectLock objectLock2 = new ObjectLock();
        Thread t3 = new Thread(objectLock2,"T3");

        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
       lock();
    }

    private void lock() {
        System.out.println("Thread : " + Thread.currentThread().getName());
        synchronized (this){
            System.out.println("Enter critical block " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Exit critical block " + Thread.currentThread().getName());
        }
    }
}
