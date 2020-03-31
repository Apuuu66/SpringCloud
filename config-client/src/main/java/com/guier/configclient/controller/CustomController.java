package com.guier.configclient.controller;

import com.guier.configclient.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @Autowired
    UserRepository userRepository;
    @Value("${spring.datasource.username}")
    public String name;

    @GetMapping("/name")
    public void run() {
        System.out.println(name);
        userRepository.findById(1);
    }


}
