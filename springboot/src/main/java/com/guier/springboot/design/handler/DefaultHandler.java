package com.guier.springboot.design.handler;

import com.guier.springboot.design.factory.Factory;

public class DefaultHandler implements Handler {
    @Override
    public void doSth() {
        System.out.println("default do");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("defaultHandler", this);
    }
}
