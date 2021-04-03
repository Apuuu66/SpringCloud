package com.guier.springboot;

import com.guier.springboot.configuration.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

// -Xms100M -Xmx100M -Xmn70M -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintGCCause -verbose:gc
@EnableAsync //开启spring事件异步设置，加@Async注解
@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {
    @Autowired
    AppConfig appConfig;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(appConfig);
    }
}
