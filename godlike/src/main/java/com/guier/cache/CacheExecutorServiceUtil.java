package com.guier.cache;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Guava缓存自定义线程池
 * @author chenzhen
 *         Created by chenzhen on 2018/11/27.
 */
public class CacheExecutorServiceUtil {

    private static final int CORE_POOL_SIZE = 10;
    private static final int MAXIMUM_POOL_SIZE = 30;
    private static final long KEEP_ALIVE_TIME = 10L;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() {
        private final ThreadFactory defaultFactory = Executors.defaultThreadFactory();
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = this.defaultFactory.newThread(r);
            if(!thread.isDaemon()) {
                thread.setDaemon(true);
            }

            thread.setName("Guava-Cache" + this.threadNumber.getAndIncrement());
            return thread;
        }
    };

    public static ExecutorService newExecutorService() {
        return new ThreadPoolExecutor(CORE_POOL_SIZE,MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, new ArrayBlockingQueue<>(200), THREAD_FACTORY);
    }

}


