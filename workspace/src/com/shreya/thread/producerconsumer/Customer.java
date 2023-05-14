package com.shreya.thread.producerconsumer;

public class Customer {
    private int balance = 10000;

    public synchronized void withdraw(int amount){
        System.out.println("going to withdraw amount : " + amount);
        if(balance < amount){
            System.out.println("oops.. you do not have sufficient balance, Please deposit the amount.");
            try {
                wait();
                if(balance > amount){
                    System.out.println("Successfully withdrawn amount : " + amount);
                    balance-=amount ;
                    System.out.println("Balance : " + balance);
                }else {
                    System.out.println("Failed...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void deposit(int amount){
        System.out.println("going to deposit amount : " + amount);
        balance+=amount;
        notify();
    }

    public static void main(String[] args) {
        Customer customer = new Customer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                customer.withdraw(15000);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                customer.deposit(10000);
            }
        });

        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
