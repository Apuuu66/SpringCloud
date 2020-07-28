package com.guier.cache.test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.guier.cache.MyTicker;

import java.util.concurrent.TimeUnit;

/**
 * 缓存一般设置的都有过期时间，如果我们写单元测试代码需要验证这个功能（缓存过期，自动删除）。
 * 假如设置的过期时间是1个小时，我们来验证1h后缓存是否被删除，那我们总不能让单元测试代码运行1个小时吧。
 */
public class TestTicker {
    public static void main(String[] args) {
        // 自定义ticker
        MyTicker myTicker = new MyTicker();

        // 创建缓存,1小时没有访问则过期
        Cache<String, byte[]> cache = CacheBuilder.newBuilder().ticker(myTicker).expireAfterAccess(1, TimeUnit.HOURS).build();
        cache.put("id", new byte[2 * 1024]);

        // 模拟时间流逝
        myTicker.addElapsedTime(TimeUnit.NANOSECONDS.convert(1, TimeUnit.HOURS));

        System.out.println(cache.getIfPresent("id") == null);//true
    }

}
