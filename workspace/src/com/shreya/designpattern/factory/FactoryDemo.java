package com.shreya.designpattern.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification smsNotification = notificationFactory.createNotification(NotificationType.SMS);
        smsNotification.notifyUser();
        Notification emailNotification = notificationFactory.createNotification(NotificationType.EMAIL);
        emailNotification.notifyUser();
    }
}
