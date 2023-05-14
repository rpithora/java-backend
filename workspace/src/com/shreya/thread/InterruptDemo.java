package com.shreya.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InterruptDemo {
    public static void main(String[] args) {
        Task task = new Task();
        Thread t1 = new Thread(task);
        t1.start();

        Thread t2 = new Thread(() -> {
            System.err.println("Hello from : " + Thread.currentThread().getName());
            t1.interrupt();
        });

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(t2, 10, TimeUnit.SECONDS);
    }
}

class Task implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("Hello from : " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread Interrupted ");
                break;
            }
        }
    }
}
