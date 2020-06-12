package com.guier.configclient.controller;

import com.guier.configclient.dao.UserRepository;
import com.guier.configclient.pojo.User;
import com.guier.configclient.service.UserService;
import com.guier.configclient.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    WorkerService workerService;
    @Value("${spring.datasource.username}")
    public String name;

    @GetMapping("/name")
    public void run() {
        System.out.println(name);
        userRepository.findById(1);
    }

    @GetMapping("/t")
    public void page() {
        userService.page(1, 10, new User().setAge(20).setName("三"));
    }

    @GetMapping("/transaction")
    public void transaction() {
        workerService.create();
    }

}
