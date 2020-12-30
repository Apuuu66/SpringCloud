package com.guier.java.jvm;

import com.guier.java.jvm.gc.TestAllocation;
import org.apache.lucene.util.RamUsageEstimator;

public class Main {
    public static void main(String[] args) {
        Integer i = new Integer(99);
        System.out.println(RamUsageEstimator.shallowSizeOf(i));
        System.out.println(RamUsageEstimator.shallowSizeOf(new TestAllocation()));
    }
}
