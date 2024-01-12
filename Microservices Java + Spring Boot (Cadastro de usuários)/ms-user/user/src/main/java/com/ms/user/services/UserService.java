package com.ms.user.services;

import com.ms.user.entitys.user.UserEntity;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositorys.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserProducer userProducer;

    @Transactional
    public UserEntity save(UserEntity userEntity) {
        userEntity = userRepository.save(userEntity);
        userProducer.publishMessageEmail(userEntity);
        return userEntity;
    }

}
