package com.ysla.reflect;

public class ClassUtilTest {

    public static void main(String[] args) {
        String s = "hello";
        ClassUtil.printClassMethodMessage(s);
        System.out.println("=============");
        ClassUtil.printClassFieldMessage(s);
        System.out.println("=============");
        ClassUtil.printConstructMessage(s);
    }

}
