package com.guier.java.concurrent.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    private static final int num = 8;
    private static final CountDownLatch cdl = new CountDownLatch(1);

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 10, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));

    public static void main(String[] args) throws InterruptedException {
        //用于获取到本java进程，进而获取总线程数
/*        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        String jvmName = runtimeBean.getName();
        System.out.println("JVM Name = " + jvmName);
        long pid = Long.valueOf(jvmName.split("@")[0]);
        System.out.println("JVM PID  = " + pid);
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        System.out.println(bean.getThreadCount());*/
        // System.out.println(Runtime.getRuntime().availableProcessors());

        // executor.allowCoreThreadTimeOut(true);
        for (int i = 0; i < num; i++) {
            executor.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    cdl.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println(executor.getCompletedTaskCount());
        cdl.countDown();
        System.out.println(executor.getCompletedTaskCount());
        executor.shutdown();

    }
}
