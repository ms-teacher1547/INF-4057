package com.m1fonda.service_notification.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.m1fonda.service_notification.model.Notification;
import com.m1fonda.service_notification.repository.NotificationRepository;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    /**
     * @param userId
       @param notificationText
     */
    public void createNotification(Long userId, String notificationText) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setMessage(notificationText);
        notification.setCreatedAt(LocalDateTime.now());

        notificationRepository.save(notification);
        System.out.println("Notification creer pour l'utilisateur : " + userId);
    }

    /* 
        @param
        @return
    */
//     public List<Notification> getNotificationsForUser(String userId) {
//         return notificationRepository.findByUserId(userId);
//     }
    
}