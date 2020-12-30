package com.guier.java.jvm.oom;

import java.util.ArrayList;

/**
 * 将堆的最小值-Xms参数与最大值-Xmx参数设置为一样即可避免堆自动扩展 ,
 * -XX: +HeapDumpOnOutOfMemoryError 内存溢出异常的时候Dump出当前的内存堆转储快照
 * VM args:  -Xms20m -Xmx20m -XX: +HeapDumpOnOutOfMemoryError
 */
public class Testoom {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }
}
