package com.ms.user.controllers;

import com.ms.user.entitys.user.UserEntity;
import com.ms.user.models.user.UserRequest;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserEntity> saveUser(@RequestBody @Valid UserRequest userRequest) {
        var userEntity = new UserEntity();
        BeanUtils.copyProperties(userRequest, userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userEntity));
    }
}
