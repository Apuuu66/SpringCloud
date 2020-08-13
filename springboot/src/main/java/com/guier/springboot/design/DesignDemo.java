package com.guier.springboot.design;

import com.guier.springboot.design.factory.Factory;
import com.guier.springboot.design.handler.AHandler;
import com.guier.springboot.design.handler.BHandler;

public class DesignDemo {
    public void noDesign(String name) {
        if (name.equals("张三")) {
            // 业务逻辑A
            System.out.println("张三完成任务AAA");
        } else if (name.equals("李四")) {
            // 业务逻辑B
            System.out.println("李四完成任务BBB");
        } else if (name.equals("王五")) {
            // 业务逻辑C
            System.out.println("王五完成任务CCC");
        }
    }

    public void step1(String name) {
        if (name.equals("张三")) {
            // 业务逻辑A
            new AHandler().doSth();
        } else if (name.equals("李四")) {
            // 业务逻辑B
            new BHandler().doSth();
        } else if (name.equals("王五")) {
            // 业务逻辑C
            System.out.println("王五完成任务CCC");
        }
    }

    public void step2(String name) {

        Factory.getInvokeStrategy(name).doSth();

    }
}
