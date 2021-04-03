package com.guier.springboot.design.listener.listener;

import com.guier.springboot.design.listener.event.OrderCreateEvent;
import org.springframework.context.ApplicationListener;

// @Async
// @Component
public class WechatListener implements ApplicationListener<OrderCreateEvent> {

    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        //发送微信
        System.out.println(event.getContentList().get(0) + ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by wechat");

    }
}
