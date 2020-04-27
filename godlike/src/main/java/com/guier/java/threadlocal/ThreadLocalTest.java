package com.guier.java.threadlocal;

import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

public class ThreadLocalTest {
    // private static final ThreadLocal<Person> THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Person> THREAD_LOCAL = new InheritableThreadLocal<>();

    @Setter
    @ToString
    private static class Person {
        private Integer age = 18;
    }

    @Test
    public void fun1() {
        // 方法入口处，设置一个变量和当前线程绑定
        setData(new Person());
        // 调用其它方法，其它方法内部也能获取到刚放进去的变量
        getAndPrintData();

        System.out.println("======== Finish =========");
    }
    @Test
    public void fun2() throws InterruptedException {
        // 方法入口处，设置一个变量和当前线程绑定
        setData(new Person());

        // getAndPrintData();
        // 异步获取数据
        Thread subThread = new Thread(() -> getAndPrintData());
        subThread.start();
        subThread.join();

        // 非异步方式获：在主线程里获取
        getAndPrintData();
        System.out.println("======== Finish =========");
    }

    @Test
    public void fun3() throws InterruptedException {
        setData(new Person());

        Thread subThread1 = new Thread(() -> {
            Person data = getAndPrintDataP();
            if (data != null)
                data.setAge(100);
            getAndPrintData(); // 再打印一次
        });
        subThread1.start();
        subThread1.join();


        Thread subThread2 = new Thread(() -> getAndPrintData());
        subThread2.start();
        subThread2.join();

        // 主线程获取线程绑定内容
        getAndPrintData();
        System.out.println("======== Finish =========");
    }


    private void setData(Person person) {
        System.out.println("set数据，线程名：" + Thread.currentThread().getName());
        THREAD_LOCAL.set(person);
    }

    private void getAndPrintData() {
        // 拿到当前线程绑定的一个变量，然后做逻辑（本处只打印）
        Person person = THREAD_LOCAL.get();
        System.out.println("get数据，线程名：" + Thread.currentThread().getName() + "，数据为：" + person);
    }

    private Person getAndPrintDataP() {
        // 拿到当前线程绑定的一个变量，然后做逻辑（本处只打印）
        Person person = THREAD_LOCAL.get();
        System.out.println("get数据，线程名：" + Thread.currentThread().getName() + "，数据为：" + person);
        return person;
    }
}

