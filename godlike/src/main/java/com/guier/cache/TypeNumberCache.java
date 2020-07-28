package com.guier.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class TypeNumberCache {
    private static UserRepository dao = new UserRepository();

    /**
     * LRU算法
     */
    private static LoadingCache<String, Integer> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(2000).refreshAfterWrite(2, TimeUnit.MINUTES)
            .build(new CacheLoader<String, Integer>() {
                //默认的数据加载实现,当调用get取值的时候,如果key没有对应的值,就调用这个方法进行加载.
                @Override
                public Integer load(String s) throws Exception {
                    Integer value = dao.listEntityBy("_type", s).size();
                    TypeNumberCache.setKey(s, value);
                    return value;
                }

                @Override
                public ListenableFuture<Integer> reload(String key, Integer oldValue) throws Exception {

                    //asynchronous,异步刷新
                    ListenableFutureTask<Integer> task = ListenableFutureTask.create(new Callable<Integer>() {
                        @Override
                        public Integer call() throws Exception {
                            return dao.listEntityBy("_type", key).size();
                        }
                    });
                    ExecutorService executorService = CacheExecutorServiceUtil.newExecutorService();
                    executorService.execute(task);
                    executorService.shutdown();
                    return task;
                }
            });

    public static void setKey(String key, Integer value) {
        localCache.put(key, value);
    }

    public static Integer getKey(String key) {
        Integer value;
        try {
            value = localCache.get(key);
            if (value == null) {
                return -1;
            }
            return value;
        } catch (Exception e) {
            System.out.println("TypeNumberCache get error" + e.getMessage());
        }
        return -1;
    }

    public static void cleanUp() {
        localCache.cleanUp();
    }
}

