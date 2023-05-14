package com.shreya.thread.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueDemo {
    Queue<Integer> queue;
    int capacity;
    Lock lock = new ReentrantLock(true);
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    BlockingQueueDemo(int max){
        queue = new LinkedList<>();
        capacity = max;
    }

    public void put(int val) throws InterruptedException {
        try{
            lock.lock();
            while (queue.size() == capacity){
                System.out.println("Queue is full.");
                notFull.await();
            }
            queue.add(val);
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void get() throws InterruptedException {
        try{
            lock.lock();
            while (queue.isEmpty()){
                System.out.println("Queue is empty.");
                notEmpty.await();
            }
            queue.poll();
            notFull.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockingQueueDemo blockingQueueDemo = new BlockingQueueDemo(10);
        Runnable producer = () -> {
            try {
                while (true){
                    blockingQueueDemo.put(1);
                    System.out.println("Added the Item");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable consumer = () -> {
            while (true){
                try {
                    blockingQueueDemo.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Consumed the Item");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(consumer).start();
    }
}
