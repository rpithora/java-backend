package com.shaurya._16companies.deshaw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public void consume(){
        while (true){
            blockingQueue.poll();
            System.out.println(Thread.currentThread().getName());
            System.out.println("Removed the Item");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void produce(){
        while (true){
            try {
                blockingQueue.put(1);
                System.out.println(Thread.currentThread().getName());
                System.out.println("Added the Item");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {BlockingQueue blockingQueue = new ArrayBlockingQueue<Integer>(10);

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
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}



