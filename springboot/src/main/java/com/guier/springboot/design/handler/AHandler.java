package com.guier.springboot.design.handler;

import com.guier.springboot.design.factory.Factory;
import com.guier.springboot.design.handler.Handler;
import org.springframework.stereotype.Component;

@Component
public class AHandler implements Handler {
    @Override
    public void doSth() {
        System.out.println("Do sth A.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("aHandler", this);
    }
}
