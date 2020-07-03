package com.guier.kafka.event;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.lang.reflect.Method;

@Setter
@Getter
@Accessors(chain = true)
public class MqEventInfo {
    private String eventType;
    private String topic;
    private Method method;
    private Object clazz;

    @Override
    public String toString() {
        return "MqEventInfo{" +
                "eventType='" + eventType + '\'' +
                ", topic='" + topic + '\'' +
                ", method=" + method +
                ", clazz=" + clazz +
                '}';
    }
}
