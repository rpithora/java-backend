package com.shreya.designpattern.factory;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending an E-Mail notification");
    }
}
