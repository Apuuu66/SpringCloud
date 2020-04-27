package com.guier.java.basis;

import lombok.Getter;

// https://blog.csdn.net/f641385712/article/details/80350192
public class StaticTest {

    public static void main(String[] args) {

        // new Child();
        staticFunction();
    }

    // 静态变量（有实例化的过程,这就是本题的重点）
    static StaticTest st = new StaticTest();
    // StaticTest st = new StaticTest();

    static {
        //System.out.println(b); // 编译报错：因为b在构造代码块后边，此处不能引用。因此Java代码是从上到下的顺序
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
        System.out.println(b);
    }

    // 这两个变量写在最后面
    int a = 110;
    static int b = 112;
}

@Getter
class Child extends Parent {
    static {
        System.out.println("Child的静态块");
    }

    {
        System.out.println("Child的构造块");
    }

    Child() {
        System.out.println("Child的构造方法");
    }
}

@Getter
class Parent {
    Integer age = 18;

    static {
        System.out.println("Parent的静态块");
    }

    {
        System.out.println("Parent的构造块");
    }

    Parent() {
        System.out.println("Parent的构造方法");
    }
}


