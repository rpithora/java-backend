package com.shreya.designpattern.creational.factory;

import static com.shreya.designpattern.creational.factory.NotificationType.*;

public class FactoryDemo {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification smsNotification = notificationFactory.createNotification(SMS);
        smsNotification.notifyUser();
        Notification emailNotification = notificationFactory.createNotification(EMAIL);
        emailNotification.notifyUser();
    }
}
