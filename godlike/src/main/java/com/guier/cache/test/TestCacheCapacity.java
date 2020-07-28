package com.guier.cache.test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.Weigher;
import org.junit.Test;
// https://blog.csdn.net/clementad/article/details/46491701
// https://blog.csdn.net/aitangyong/category_6482857.html
public class TestCacheCapacity {
    @Test
    public void t1() {
        // 创建1个cache,最多能存放5个缓存条目
        Cache cache = CacheBuilder.newBuilder().recordStats().maximumSize(5).build();
        for (int i = 0; i < 10; i++) {
            cache.put(i, i);
        }
        // 6 = 6, 5 = 5, 9 = 9, 7 = 7, 8 = 8
        System.out.println(cache.asMap());
    }

    @Test
    public void t2() {
        // 创建1个cache,最大权重是100,如果缓存值是偶数占20个权重,奇数占5个权重
        Cache<Integer, Integer> cache = CacheBuilder.newBuilder().recordStats().
                maximumWeight(100L).weigher(new Weigher<Integer, Integer>() {
            @Override
            public int weigh(Integer key, Integer value) {
                if (value % 2 == 0) {
                    return 20;
                } else {
                    return 5;
                }
            }
        }).build();

        // 放偶数
        for (int i = 0; i < 100; i += 2) {
            cache.put(i, i);
        }

        // {6=6, 8=8, 2=2, 4=4}
        System.out.println(cache.asMap());

        // 清空所有缓存
        cache.invalidateAll();

        // 放奇数
        for (int i = 1; i < 100; i += 2) {
            cache.put(i, i);
        }
        // 6 = 6, 5 = 5, 8 = 8, 7 = 7, 2 = 2, 9 = 9, 3 = 3, 4 = 4
        System.out.println(cache.asMap());
    }

    @Test
    public void t3() {
    }

    @Test
    public void t4() {
    }

    @Test
    public void t5() {
    }

}
