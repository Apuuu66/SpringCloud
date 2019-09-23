package com.guier.eurekaclientmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EurekaClientMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientMovieApplication.class, args);
    }
//    使用feign 暂时注释restTemplate
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
