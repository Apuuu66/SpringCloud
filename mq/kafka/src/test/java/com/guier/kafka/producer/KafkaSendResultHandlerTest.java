package com.guier.kafka.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KafkaSendResultHandlerTest {
    @Autowired
    private KafkaSendResultHandler producerListener;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void onSuccess() {
    }

    @Test
    public void onError() {
    }

    @Test
    public void testProducerListen() throws InterruptedException {
        kafkaTemplate.setProducerListener(producerListener);
        kafkaTemplate.send("topic.quick.demo", "test producer listen");
        Thread.sleep(1000);
    }
}