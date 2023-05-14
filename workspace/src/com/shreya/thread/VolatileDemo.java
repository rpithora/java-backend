package com.shreya.thread;

class Test1{
    boolean flag = true;
    public void writer(){
        flag = false;
    }
    public void reader(){
        int cnt = 0;
        while (flag){
            System.out.println("reader" + cnt++);
        }
        System.out.println("outside while.");
    }
}
public class VolatileDemo {


    public static void main(String[] args) {

        Test1 test1 = new Test1();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                test1.reader();
            }
        };
        Thread t1 = new Thread(runnable1);
        t1.start();

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                test1.writer();
            }
        };
        Thread t2 = new Thread(runnable2);
        t2.start();
    }
}
