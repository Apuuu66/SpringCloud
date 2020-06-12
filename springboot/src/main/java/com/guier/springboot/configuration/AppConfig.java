package com.guier.springboot.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@Data
@ConfigurationProperties(prefix = "my.config")
public class AppConfig {
    List<String> list;
    Map<String, String> map;
    List<Host> objList;
    private Host host;
    Map<String, Host> objMap;

    @Data
    public static class Host {
        private String ip;
        private int port;
    }

}
