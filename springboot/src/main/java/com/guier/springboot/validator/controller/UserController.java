package com.guier.springboot.validator.controller;

import com.guier.springboot.pojo.OOMObject;
import com.guier.springboot.validator.dto.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    @PostMapping("/save/valid")
    public Object save(@RequestBody @Validated UserDTO userDTO) {
        System.out.println(userDTO);
        return userDTO;
    }

    @GetMapping("/test")
    public void ttt() throws InterruptedException {
        ArrayList<OOMObject> list = new ArrayList<>();
        for (int j = 0; j < 1000; j++) {
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(j + 1);
            list.add(new OOMObject());
        }
        System.gc();
    }
}
