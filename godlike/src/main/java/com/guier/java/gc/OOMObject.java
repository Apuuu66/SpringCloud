package com.guier.java.gc;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class OOMObject {
    public byte[] placeholder = new byte[2 * 1024 * 1024];

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

    private static void fillHeap(int i) throws InterruptedException {
        ArrayList<OOMObject> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(j + 1);
            list.add(new OOMObject());
        }
        System.gc();
    }
}
