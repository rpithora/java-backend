package com.shaurya._16companies.deshaw;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockDemo implements Runnable {

    private ReentrantLock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();

    @Override
    public void run() {
        try{
            lock.lock();
            while (true){
                System.out.println("Hello from " + Thread.currentThread().getName());
                condition.signal();
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReenterLockDemo reenterLockDemo = new ReenterLockDemo();
        new Thread(reenterLockDemo).start();
        new Thread(reenterLockDemo).start();
    }
}
