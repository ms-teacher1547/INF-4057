package com.m1fonda.service_notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m1fonda.service_notification.model.Notification;
import com.m1fonda.service_notification.repository.NotificationRepository;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    /**
     * Récupère toutes les notifications pour un utilisateur spécifique
     *
     * @param userId ID de l'utilisateur
     * @return Liste de notifications ou erreur 404 si aucune notification n'est trouvée
     */
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserNotifications(@PathVariable Long userId) {
        // Recherche des notifications par userId
        List<Notification> notifications = notificationRepository.findByUserId(userId);

        // Si aucune notification n'est trouvée
        if (notifications.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No notifications found for user ID: " + userId);
        }

        // Si des notifications sont trouvées
        return ResponseEntity.ok(notifications);
    }
}
