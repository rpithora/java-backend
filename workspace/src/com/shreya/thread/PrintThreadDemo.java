package com.shreya.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Printer {
    ReentrantLock lock = new ReentrantLock(true);
    Condition number = lock.newCondition();
    Condition capital = lock.newCondition();
    Condition small = lock.newCondition();

    public void printNumber() {
        try {
            lock.lock();
            for (int i = 1; i <= 26; i++) {
                System.out.println();
                System.out.print(i + " ");
                capital.signal();
                number.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printCapitalLetter() {
        try {
            lock.lock();
            for (int i = 0; i < 26; i++) {
                System.out.print((char) (i + 97) + " ");
                small.signal();
                capital.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printSmallLetter() {
        try {
            lock.lock();
            for (int i = 0; i < 26; i++) {
                System.out.print((char) (i + 65) + " ");
                number.signal();
                small.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class PrintThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> printer.printNumber());
        executorService.submit(() -> printer.printCapitalLetter());
        executorService.submit(() -> printer.printSmallLetter());

        executorService.awaitTermination(3, TimeUnit.SECONDS);
    }
}
