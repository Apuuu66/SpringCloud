package com.guier.kafka.service;

import com.guier.kafka.event.MessageHandle;
import com.guier.kafka.event.ServiceEvent;
import org.springframework.stereotype.Service;

@Service
public class HandleMessageA implements MessageHandle {
    @ServiceEvent(eventType = "serviceA-add")
    public void add(String message) {
        System.out.println(message);
    }

    @ServiceEvent(eventType = "serviceA-update")
    public void update(String message) {
        System.out.println(message);
    }

    @ServiceEvent(eventType = "serviceA-delete")
    public void delete(String message) {
        System.out.println(message);
    }

    public void handle(String message) {
        System.out.println(message);
    }
}
