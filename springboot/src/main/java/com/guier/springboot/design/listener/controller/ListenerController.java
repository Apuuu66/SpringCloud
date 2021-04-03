package com.guier.springboot.design.listener.controller;

import com.guier.springboot.design.listener.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listener")
public class ListenerController {
    @Autowired
    OrderService orderService;

    @GetMapping
    public void test() {
        orderService.saveOrder();
    }
}
