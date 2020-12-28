package com.guier.java.oom;

public class DoEscapeAnalysis {
    /**
     * 关闭逃逸分析
     * -Xmx10m -Xms10m -XX:+PrintGC -XX:-DoEscapeAnalysis
     */


    public static void main(String[] args) {
        while (true) {
            Integer integer = new Integer(111111111);
        }
    }
}
