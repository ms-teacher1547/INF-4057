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

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@Tag(name = "Notification", description = "Endpoints pour gerer les notifications") // Groupe Swagger
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    /**
     * Récupère toutes les notifications pour un utilisateur spécifique
     *
     * @param userId ID de l'utilisateur
     * @return Liste de notifications ou erreur 404 si aucune notification n'est trouvée
     */
    @Operation(
        summary = "Recuperer les notifications d'un utilisateur",
        description = "Renvoie toutes les notifications pour un utilisateur donne donne via son ID."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notification recuperees avec succes"),
        @ApiResponse(responseCode = "404", description = "Aucune notification trouvee pour cet utilisateur"),
        @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable Long userId) {
        // Recherche des notifications par userId
        List<Notification> notifications = notificationRepository.findByUserId(userId);

        // Si aucune notification n'est trouvée
        if (notifications.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        // Si des notifications sont trouvées
        return ResponseEntity.ok(notifications);
    }
}
