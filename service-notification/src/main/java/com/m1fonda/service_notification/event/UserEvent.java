package com.m1fonda.service_notification.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEvent {

    @JsonProperty("id")
    @Positive(message = "L'ID doit être un entier positif.")
    private int id;

    @JsonProperty("name")
    @NotBlank(message = "Le nom de l'utilisateur ne peut pas être vide.")
    private String name;

    @JsonProperty("email")
    @Email(message = "L'adresse e-mail doit être valide.")
    @NotBlank(message = "L'adresse e-mail est obligatoire.")
    private String email;
}