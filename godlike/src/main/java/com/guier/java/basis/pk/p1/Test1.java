package com.guier.java.basis.pk.p1;

import com.guier.java.basis.pk.p2.Son2;

/**
 * ref https://blog.csdn.net/justloveyou_/article/details/61672133
 */
public class Test1 {
    public static void main(String[] args) {
        Son1 son1 = new Son1();
        son1.f();
        // son1.clone();
        Son2 son2 = new Son2();
        son2.f();
        // son2.clone();

    }
}
