package com.ms.email.services;

import com.ms.email.entitys.EmailEntity;
import com.ms.email.enums.StatusEmail;
import com.ms.email.repositorys.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;
    @Autowired
    JavaMailSender emailSender;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public EmailEntity sendEmail(EmailEntity emailEntity) {
        try {
            emailEntity.setSendDataEmail(LocalDateTime.now());
            emailEntity.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailEntity.getEmailTo());
            message.setSubject(emailEntity.getSubject());
            message.setText(emailEntity.getText());
            emailSender.send(message);

            emailEntity.setStatusEmail(StatusEmail.SENT);
        }
        catch (MailException ex) {
            emailEntity.setStatusEmail(StatusEmail.ERROR);
        }
        finally {
            emailRepository.save(emailEntity);
        }
        return emailEntity;
    }
}
