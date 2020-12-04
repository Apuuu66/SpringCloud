package com.guier.java.threadpool;

import lombok.SneakyThrows;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.*;

public class ThreadPoolDemo {
    @SneakyThrows
    public static void main(String[] args) throws MalformedURLException {

        // new ThreadPoolDemo().t1();
        new ThreadPoolDemo().t2();
    }


    public void t1() throws MalformedURLException {
        ArrayBlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 10,
                TimeUnit.SECONDS, blockingQueue, new AbortPolicyWithReport("", new URL("http://")));

        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        };

        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        // TimeUnit.SECONDS.sleep(10);
    }

    public void t2() throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(50, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(100000));
        for (int i = 0; i < 10000; i++) {
            es.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
        }

        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) es);
        while (true) {
            System.out.println();
            int queueSize = tpe.getQueue().size();
            System.out.println("当前排队线程数：" + queueSize);
            int activeCount = tpe.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);
            long completedTaskCount = tpe.getCompletedTaskCount();
            System.out.println("执行完成线程数：" + completedTaskCount);
            long taskCount = tpe.getTaskCount();

            System.out.println("总线程数：" + taskCount);
            String msg = String.format("Thread pool is EXHAUSTED! Thread Name: %s, " +
                            "\nPool Size: %d (active: %d, core: %d, max: %d, largest: %d)," +
                            "\nTask: %d (completed: %d)," +
                            "\nExecutor status:(isShutdown:%s, isTerminated:%s, isTerminating:%s).", "threadName",
                    tpe.getPoolSize(), tpe.getActiveCount(), tpe.getCorePoolSize(), tpe.getMaximumPoolSize(), tpe.getLargestPoolSize(),
                    tpe.getTaskCount(), tpe.getCompletedTaskCount(),
                    tpe.isShutdown(), tpe.isTerminated(), tpe.isTerminating());

            System.out.println(msg);
            Thread.sleep(5000);

        }
    }
}
