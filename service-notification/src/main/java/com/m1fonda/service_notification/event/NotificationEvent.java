package com.m1fonda.service_notification.event;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationEvent {
    // Convertissons le json en chaine de caractere ou evenement
    @JsonProperty("id")
    private int id;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("message")
    private String message;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    public void setUserId(int userId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUserId'");
    }

    public void setMessage(String message2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMessage'");
    }

    public void setTimestamp(LocalDateTime timestamp2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTimestamp'");
    }
}
