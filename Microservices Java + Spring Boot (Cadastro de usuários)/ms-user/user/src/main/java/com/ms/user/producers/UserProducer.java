package com.ms.user.producers;

import com.ms.user.entitys.user.UserEntity;
import com.ms.user.models.email.EmailRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserEntity userEntity) {
        var emailModel = new EmailRequest();
        emailModel.setUserId(userEntity.getUserId());
        emailModel.setEmailTo(userEntity.getEmail());
        emailModel.setSubject("Cadastro realizado com sucesso!");
        emailModel.setText(userEntity.getName() + ", seja bem-vindo(a)! \n Agradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma.");

        rabbitTemplate.convertAndSend("", routingKey, emailModel);
    }
}
