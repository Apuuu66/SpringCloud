package com.guier.kafka.event;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceEvent {
    String eventType() default "";

    String topic() default "";
}
