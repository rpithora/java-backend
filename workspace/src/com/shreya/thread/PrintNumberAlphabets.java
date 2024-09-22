package com.shreya.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumberAlphabets {
    static class Printer {

        ReentrantLock lock = new ReentrantLock(true);
        Condition number = lock.newCondition();
        Condition upperCase = lock.newCondition();
        Condition lowerCase = lock.newCondition();

        public void printNumber() {
            try {
                lock.lock();
                for (int i = 1; i <= 26; i++) {
                    System.out.print(i);
                    upperCase.signal();
                    number.await();
                    System.out.println();
                }
                System.out.println();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        }

        public void printAlphabet() {
            try {
                lock.lock();
                for (int i = 0; i < 26; i++) {
                    System.out.print((char) (97 + i));
                    lowerCase.signal();
                    upperCase.await();
                }
                System.out.println();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        }

        public void printAlphabet2() {
            try {
                lock.lock();
                for (int i = 0; i < 26; i++) {
                    System.out.print((char) (65 + i));
                    number.signal();
                    lowerCase.await();
                }
                System.out.println();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Printer printer = new Printer();
        executorService.submit(printer::printNumber);
        executorService.submit(printer::printAlphabet);
        executorService.submit(printer::printAlphabet2);
        executorService.shutdown();
    }
}
