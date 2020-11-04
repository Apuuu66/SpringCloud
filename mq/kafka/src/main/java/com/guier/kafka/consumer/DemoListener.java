package com.guier.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener {

    private static final Logger log= LoggerFactory.getLogger(DemoListener.class);

    //声明consumerID为demo，监听topicName为kafka-test的Topic
    @KafkaListener(id = "demo", topics = "kafka-test")
    public void listen(String msgData) {
        log.info("demo receive : "+msgData);
    }
}

