package com.guier.java.basis.pk.p2;

import com.guier.java.basis.pk.p1.MyObject2;

public class Test3 extends MyObject2 {
    public static void main(String args[]) throws CloneNotSupportedException {
        MyObject2 obj = new MyObject2();
        // obj.clone(); // Compile Error         ----（1）

        Test3 tobj = new Test3();
        tobj.clone(); // Complie OK         ----（2）
    }
}
