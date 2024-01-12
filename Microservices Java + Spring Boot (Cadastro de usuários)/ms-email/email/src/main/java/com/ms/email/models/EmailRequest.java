package com.ms.email.models;

import java.util.UUID;

public record EmailRequest(
        UUID userId,
        String emailTo,
        String subject,
        String text
) { }
