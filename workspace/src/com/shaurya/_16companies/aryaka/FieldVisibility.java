package com.shaurya._16companies.aryaka;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class FieldVisibility {
    int x = 0;

    public static void main(String[] args) {
        FieldVisibility fieldVisibility = new FieldVisibility();
        new Thread(() -> fieldVisibility.readerThread(),"Reader").start();
        new Thread(() -> fieldVisibility.writeThread(), "Writer").start();

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        threadPool.submit(new Thread(() -> fieldVisibility.readerThread(),"Reader"));
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(10);
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    }

    public void writeThread() {
        while (true){
            x = 1;
            System.out.println("Thread Name : " + Thread.currentThread().getName() + " Found value : " + x);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void readerThread() {
        while (true){
            int r2 = x;
            System.out.println("Thread Name : " + Thread.currentThread().getName() + " Found value : " + r2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
