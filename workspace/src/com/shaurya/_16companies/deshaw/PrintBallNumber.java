package com.shaurya._16companies.deshaw;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintBallNumber {

    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printNumber(){
        try{
            lock.lock();
            for(int i=1; i<=26; i++){
                System.out.print(i);
                condition2.signal();
                condition1.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printCap(){
        try{
            lock.lock();
            for(int i=1; i<=26; i++){
                System.out.print((char)(i + 96));
                condition3.signal();
                condition2.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printSmall(){
        try{
            lock.lock();
            for(int i=1; i<=26; i++){
                System.out.print((char)(i + 64));
                System.out.println();
                Thread.sleep(1000);
                condition1.signal();
                condition3.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintBallNumber printBallNumber = new PrintBallNumber();
        new Thread(() -> printBallNumber.printNumber()).start();
        new Thread(() -> printBallNumber.printCap()).start();
        new Thread(() -> printBallNumber.printSmall()).start();
    }
}
