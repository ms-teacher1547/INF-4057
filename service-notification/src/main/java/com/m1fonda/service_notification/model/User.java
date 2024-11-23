package com.m1fonda.service_notification.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Le nom ne peut pas être vide.")
    private String username;

    @NotBlank(message = "le cni_number ne peut pas etre vide")
    private String cni_number;

    @Email(message = "L'adresse e-mail doit être valide.")
    @NotBlank(message = "L'adresse e-mail est obligatoire.")
    private String email;

    @NotBlank(message = "Le password ne peut pas etre vide")
    private String password;
}
