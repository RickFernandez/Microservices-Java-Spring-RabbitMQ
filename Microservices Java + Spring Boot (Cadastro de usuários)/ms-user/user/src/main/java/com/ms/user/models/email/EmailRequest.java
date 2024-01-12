package com.ms.user.models.email;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmailRequest {
    UUID userId;
    String emailTo;
    String subject;
    String text;
}
