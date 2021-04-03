package com.guier.springboot.design.listener.smartlistiner;

import com.guier.springboot.design.listener.OrderServiceEventImpl;
import com.guier.springboot.design.listener.event.OrderCreateEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SmsSmartListener implements SmartApplicationListener {
    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == OrderCreateEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == OrderServiceEventImpl.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        OrderCreateEvent event = (OrderCreateEvent) applicationEvent;
        //发送短信
        System.out.println(event.getContentList().get(0) + ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by sms");

    }

//    @Override
//    @Async
//    public void onApplicationEvent(OrderCreateEvent event) {
//
//        //发送短信
//        System.out.println(event.getContentList().get(0) + ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by sms");
//
//    }
}
