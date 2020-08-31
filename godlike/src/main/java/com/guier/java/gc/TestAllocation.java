package com.guier.java.gc;

import java.util.concurrent.TimeUnit;

/**
 * VM参数：-verbose:gc -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 */
public class TestAllocation {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[3 * _1MB];
        allocation4 = new byte[6 * _1MB];

        byte[][] a = new byte[20][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new byte[2*_1MB];
            TimeUnit.SECONDS.sleep(1);
            System.out.println(i);
        }

    }
}
