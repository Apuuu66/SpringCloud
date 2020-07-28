package com.guier.cache.test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * expireAfterAccess：缓存项在给定时间内没有被读/写访问，则回收。
 * expireAfterWrite：缓存项在给定时间内没有被写访问（创建或覆盖），则回收。
 */
public class TestCacheExpire {
    public static void main(String[] args) {
        // 缓存5s内没有访问(包括读和写),则缓存会被移除
        Cache<Integer, Object> cache = CacheBuilder.newBuilder().recordStats()
                .expireAfterAccess(2, TimeUnit.SECONDS).build();

        cache.put(1, new Object());
        System.out.println(cache.getIfPresent(1));//not null

        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }

        System.out.println(cache.getIfPresent(1));//null
    }
}
