package com.guier.kafka.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventMessage {
    private String eventType;
    private String messageBody;
    private long createdTime;
}
