package com.guier.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {
    @Value("${custom.name}")
    public String name;

    @GetMapping("/name")
    public void run() {
        System.out.println(name);
    }
}
