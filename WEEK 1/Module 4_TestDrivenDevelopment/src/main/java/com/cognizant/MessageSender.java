package com.cognizant;

public class MessageSender {

    private NotificationService notificationService;

    public MessageSender(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void send(String message) {
        notificationService.sendNotification(message);
    }
}