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
    private String name;

    @Email(message = "L'adresse e-mail doit être valide.")
    @NotBlank(message = "L'adresse e-mail est obligatoire.")
    private String email;
}
