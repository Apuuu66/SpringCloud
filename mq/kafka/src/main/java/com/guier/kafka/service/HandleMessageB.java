package com.guier.kafka.service;

import com.guier.kafka.event.MessageHandle;
import com.guier.kafka.event.ServiceEvent;
import org.springframework.stereotype.Service;

@Service
public class HandleMessageB implements MessageHandle {
    @ServiceEvent(eventType = "serviceB-add")
    public void add(String message) {
        System.out.println(message);
    }

    @ServiceEvent(eventType = "serviceB-update")
    public void update(String message) {
        System.out.println(message);
    }

    @ServiceEvent(eventType = "serviceB-delete")
    public void delete(String message) {
        System.out.println(message);
    }

    public void handle(String message) {
        System.out.println(message);
    }
}
