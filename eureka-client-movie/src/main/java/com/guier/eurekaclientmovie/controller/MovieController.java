package com.guier.eurekaclientmovie.controller;

import com.guier.eurekaclientmovie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/movies")
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
//        User user = this.restTemplate.getForObject("http://localhost:8085/users/{id}", User.class, id);

        /*将请求的目标服务改成了http://eureka-client-user/users/{id} ，也就是http://{目标服务名称}/{目标服务端点} 的形式，
        Ribbon会自动在实际调用时，将目标服务名替换为该服务的IP和端口。*/
        User user = this.restTemplate.getForObject("http://eureka-client-user/users/{id}", User.class, id);
        // ...电影微服务的业务...
        return user;
    }
}
