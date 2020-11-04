package com.guier.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guier.kafka.event.EventMessage;
import com.guier.kafka.event.MessageHandle;
import com.guier.kafka.event.MqEventInfo;
import com.guier.kafka.event.ServiceEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.stream.Stream;

@Component
public class Receiver implements BeanPostProcessor {
    HashMap<String, MqEventInfo> map = new HashMap<>();
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MessageHandle) {
            Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
            Stream.of(methods).filter(m -> m.isAnnotationPresent(ServiceEvent.class))
                    .forEach(m -> {
                        ServiceEvent annotation = m.getAnnotation(ServiceEvent.class);
                        String eventType = annotation.eventType();
                        MqEventInfo eventInfo = new MqEventInfo().setEventType(eventType).setMethod(m).setClazz(bean);
                        map.put(eventType, eventInfo);
                    });
        }
        return bean;
    }

    // {"eventType":"serviceB-update","messageBody":"serviceB-update do do do...","createdTime":0}
    @KafkaListener(groupId = "group01", topics = "kafka-test")
    public void receive(ConsumerRecord<?, ?> consumerRecord) throws IOException, InvocationTargetException, IllegalAccessException {
        System.out.println(consumerRecord.value().toString());
        try {
            EventMessage eventMessage = objectMapper.readValue(consumerRecord.value().toString(), EventMessage.class);
            MqEventInfo mqEventInfo = map.get(eventMessage.getEventType());
            mqEventInfo.getMethod().invoke(mqEventInfo.getClazz(), eventMessage.getMessageBody());
        } catch (IOException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ignored) {

        }
    }
}
