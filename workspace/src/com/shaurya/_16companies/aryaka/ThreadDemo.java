package com.shaurya._16companies.aryaka;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo implements Runnable{
    private boolean flag = true;
    private int counter = 0;
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag) {
            synchronized (this){
                counter++;
                System.out.println("Hello from " + Thread.currentThread().getName() + counter);
                notify();
                try {
                    wait();
                   Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if(flag == false)
            System.err.println("Hello from " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();

        Thread t1 = new Thread(threadDemo);
        Thread t2 = new Thread(threadDemo);

        t1.start();
        t2.start();

        Timer timer = new Timer();
        TimerTask task = new Helper(threadDemo);
        timer.schedule(task, 5000);

        Thread t3 = new Thread(() -> {
            threadDemo.setFlag(false);
        });

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
        scheduledThreadPool.schedule(t3, 10, TimeUnit.SECONDS);
    }
}

class Helper extends TimerTask
{
    ThreadDemo threadDemo ;
    public Helper(ThreadDemo threadDemo){
        this.threadDemo = threadDemo;
    }
    public void run()
    {
        System.out.println("Timer Task executed.");
        threadDemo.setFlag(false);
        Thread t1 = new Thread(threadDemo);
        t1.start();
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
        System.out.println("AtomicInteger :::: " + atomicInteger);
    }
}
