package com.guier.eurekaclientuser.controller;

import com.guier.eurekaclientuser.pojo.User;
import com.guier.eurekaclientuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public Object getAll() {
        System.out.println(port);
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Integer id) {
        System.out.println(port);
        return this.userRepository.findById(id);
    }
}
