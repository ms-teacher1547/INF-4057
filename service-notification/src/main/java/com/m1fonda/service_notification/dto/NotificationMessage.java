package com.m1fonda.service_notification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NotificationMessage {

    @NotNull(message = "UserID cannot be null")
    private String userId;
    @NotBlank(message = "eventType cannot be blank")
    private String eventType;
}

