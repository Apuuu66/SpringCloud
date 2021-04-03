package com.guier.springboot.design.listener;

public class OrderServiceImpl implements OrderService {
    @Override
    public void saveOrder() {
        //1.创建订单
        System.out.println("订单创建成功");
        //2.发送短信
        System.out.println("恭喜您订单创建成功！----by sms");
        //新需求：微信通知
        // 3.发送微信
        System.out.println("恭喜您订单创建成功！----by wechat");
    }
}
