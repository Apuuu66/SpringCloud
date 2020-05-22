package com.guier.eurekaclientuser;

import com.guier.eurekaclientuser.pojo.User;
import com.guier.eurekaclientuser.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class EurekaClientUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientUserApplication.class, args);
    }

    @Bean
    ApplicationRunner init(UserRepository repository) {
        return args -> {
            User user1 = new User(1, "张三", 20, new Date(), "");
            User user2 = new User(2, "李四", 28, new Date(), "");
            User user3 = new User(3, "王五", 32, new Date(), "");
            Stream.of(user1, user2, user3)
                    .forEach(repository::save);
        };
    }
}
