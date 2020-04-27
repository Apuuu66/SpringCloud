package com.guier.java.basis;

import java.lang.reflect.Constructor;

public class EnumReflectively {
    //拿构造方法
    public static void main(String[] args) throws Exception {
        t1();
        // t2();
    }

    // 反射构造枚举 失败
    public static void t1() throws Exception {
        EnumSingleton s = EnumSingleton.INSTANCE;

        // 拿到所有的构造函数，包括非public的
        Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        // 使用空构造函数new一个实例。即使它是private的~~~
        EnumSingleton sReflection = constructor.newInstance();
        // 没有构造方法 java.lang.NoSuchMethodException: com.guier.java.basis.EnumSingleton.<init>()

        System.out.println(s); //com.fsx.bean.Singleton@1f32e575
        System.out.println(sReflection); //com.fsx.bean.Singleton@279f2327
        System.out.println(s == sReflection); // false
    }

    // 用父类的构造方法
    // Constructor的417行报错
    public static void t2() throws Exception {
        EnumSingleton s = EnumSingleton.INSTANCE;

        // 拿到所有的构造函数，包括非public的
        Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);// 拿到有参的构造器
        constructor.setAccessible(true);
        // 使用空构造函数new一个实例。即使它是private的~~~
        System.out.println("拿到了构造器：" + constructor);
        EnumSingleton sReflection = constructor.newInstance("testInstance", 1);

        System.out.println(s); //com.fsx.bean.Singleton@1f32e575
        System.out.println(sReflection); //com.fsx.bean.Singleton@279f2327
        System.out.println(s == sReflection); // false
    }

}

