package com.m1fonda.service_notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.m1fonda.service_notification.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Méthode personnalisée pour trouver un utilisateur par email
    Optional<User> findByEmail(String email);

    // Méthode personnalisée pour vérifier si un utilisateur existe avec un certain email
    boolean existsByEmail(String email);
}
