package com.shreya.designpattern.creational.factory;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending an E-Mail notification");
    }
}
