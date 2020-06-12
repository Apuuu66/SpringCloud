package com.guier.configclient;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class ConfigClientApplicationTests {
    public volatile int num;

    @Test
    public void contextLoads() throws InterruptedException {
        Runnable runnable = () -> {
            // synchronized (ConfigClientApplicationTests.class) {
                for (int i = 0; i < 10000; i++) {
                    num++;
                }
            // }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(num);
    }

}
