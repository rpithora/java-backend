package com.shreya.thread.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UsingBlockingQueue {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue blockingQueue = new ArrayBlockingQueue<Integer>(10);

        Runnable producer = () -> {
            try {
                while (true){
                    blockingQueue.put(1);
                    System.out.println("Added the Item");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable consumer = () -> {
            while (true){
                blockingQueue.poll();
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
        //new Thread(consumer).start();
    }

}
