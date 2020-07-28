package com.guier.cache.test;

import com.google.common.cache.*;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestRemovalListener {
    // 创建一个监听器
    private static class MyRemovalListener implements RemovalListener<Integer, Integer> {
        @Override
        public void onRemoval(RemovalNotification<Integer, Integer> notification) {
            String tips = String.format("key=%s,value=%s,reason=%s", notification.getKey(), notification.getValue(), notification.getCause());
            try {
                // 模拟耗时
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**
             * 监听器中抛出的任何异常，在被记录到日志后，会被guava丢弃，不会导致监听器不可用。
             * 下面这段代码可以看到：监听器中抛出的异常只是被记录了(打印到了控制台)，并没有导致JVM退出，之后缓存被移除一样可以再次触发。
             */
            if (notification.getKey() == 1) {
                throw new RuntimeException();
            }
            System.out.println(tips);
        }
    }

    public static void main(String[] args) {

        // 创建一个带有RemovalListener同步监听的缓存
        // Cache<Integer, Integer> cache = CacheBuilder.newBuilder().removalListener(new MyRemovalListener()).build();

        // 创建异步监听
        ExecutorService executor = Executors.newSingleThreadExecutor();
        RemovalListener<Integer, Integer> async = RemovalListeners.asynchronous(new MyRemovalListener(), executor);
        // 创建一个带有RemovalListener监听的缓存
        final Cache<Integer, Integer> cache = CacheBuilder.newBuilder().removalListener(async).build();

        cache.put(1, 1);
        cache.put(2, 1);

        // 手动清除
        cache.invalidate(1);
        cache.invalidate(2);

        System.out.println(cache.getIfPresent(1)); // null
        executor.submit(() -> System.out.println(123));
        executor.shutdown();
    }

    @Test
    public void t() {

    }
}
