package com.m1fonda.service_notification.Brocker;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.m1fonda.service_notification.service.NotificationService;

@Component
public class NotificationListener {

    private final NotificationService notificationService;

    public NotificationListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "userNotificationQueue")
    public void handleUserEvent(Map<String, Object> message) {
        Long userId = (Long) message.get("userId");
        String notificationContent = (String) message.get("content");

        notificationService.createNotification(userId, notificationContent);
    }
}
