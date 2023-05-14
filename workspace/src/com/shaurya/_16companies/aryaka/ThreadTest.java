package com.shaurya._16companies.aryaka;

public class ThreadTest {
    int counter1 = 0;
    int counter2 = 0;

    public void method1()  {
        synchronized (ThreadTest.class) {
            while (counter1 <= 3) {
                System.out.println("Inside Method1 " + Thread.currentThread().getName() + " Counter :  " + counter1);
                counter1++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void method2()  {
        while (counter2 <= 3) {
            System.err.println("Inside Method2 " + Thread.currentThread().getName() + " Counter :  " + counter2);
            counter2++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadPractice {
    public static void main(String[] args) {
        ThreadTest threadTest1 = new ThreadTest();
        ThreadTest threadTest2 = new ThreadTest();
        Thread t1 = new Thread(() -> {
            threadTest1.method1();
        });
        Thread t2 = new Thread(() -> {
            threadTest1.method2();
        });
        Thread t3 = new Thread(() -> {
            threadTest2.method1();
        });
        Thread t4 = new Thread(() -> {
            threadTest2.method2();
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
