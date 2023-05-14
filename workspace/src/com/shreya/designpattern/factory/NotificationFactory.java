package com.shreya.designpattern.factory;

public class NotificationFactory {
    public Notification createNotification(NotificationType channel) {
        switch (channel){
            case SMS:
                return new SMSNotification();
            case EMAIL:
                return new EmailNotification();
            default:
                throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}
