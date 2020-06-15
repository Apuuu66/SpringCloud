package com.guier.springboot.validator.controller;

import com.guier.springboot.validator.dto.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/save/valid")
    public Object save(@RequestBody @Validated UserDTO userDTO) {
        System.out.println(userDTO);
        return userDTO;
    }
}
