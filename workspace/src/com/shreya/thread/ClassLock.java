package com.shreya.thread;

public class ClassLock implements Runnable {

    @Override
    public void run() {
        lock();
    }

    private void lock() {
        System.out.println("Thread : " + Thread.currentThread().getName());
        synchronized (ClassLock.class){
            System.out.println("Enter critical block " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Exit critical block " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ClassLock classLock1 = new ClassLock();
        Thread t1 = new Thread(classLock1,"T1");
        Thread t2 = new Thread(classLock1,"T2");

        ClassLock classLock2 = new ClassLock();
        Thread t3 = new Thread(classLock2,"T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
