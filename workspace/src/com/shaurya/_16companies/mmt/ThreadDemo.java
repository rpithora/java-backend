package com.shaurya._16companies.mmt;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Printer {
    ReentrantLock lock = new ReentrantLock(true);
    Condition number = lock.newCondition();
    Condition capital = lock.newCondition();
    Condition small = lock.newCondition();

    public void printNumber(){
        try{
            lock.lock();
            for(int i=1; i<=26; i++){
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

    public void printCapitalLetter(){
        try{
            lock.lock();
            for(int i=1; i<=26; i++){
                System.out.print((char)(i + 96) + " ");
                small.signal();
                capital.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printSmallLetter(){
        try{
            lock.lock();
            for(int i=1; i<=26; i++){
                System.out.print((char)(i + 64) + " ");
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
public class ThreadDemo {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(() -> printer.printNumber());
        Thread t2 = new Thread(() -> printer.printCapitalLetter());
        Thread t3 = new Thread(() -> printer.printSmallLetter());
        t1.start();
        t2.start();
        t3.start();
    }
}
