package com.m1fonda.service_notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.m1fonda.service_notification.model.Notification;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Méthode personnalisée pour trouver les notifications d'un utilisateur
    List<Notification> findByUserId(Long userId);

    // Méthode pour obtenir une notification par son id
    @SuppressWarnings("null")
    Optional<Notification> findById(Long id);

    // Méthode pour trouver les notifications créées après une certaine date
    List<Notification> findByCreatedAtAfter(LocalDateTime date);
}
