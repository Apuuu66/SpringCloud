package com.guier.java.basis.modifier;

public class Main {
    public static void main(String[] args) {
        System.out.println(Class1.class.getModifiers());
        Class<? extends Class> aClass = Class1.class.getClass();
        // !waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers())
        //         && WebApplicationInitializer.class.isAssignableFrom(waiClass))
    }
}
