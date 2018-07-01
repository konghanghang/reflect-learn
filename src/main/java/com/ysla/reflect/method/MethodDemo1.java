package com.ysla.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo1 {

    public static void main(String[] args) {
        A a1 = new A();
        Class c = a1.getClass();
        /**
         * 获取方法,名称和参数列表来决定
         * getMethod获取public方法
         * getDeclaredMethod自己声明的方法
         */
        try {
            //获取方法对象
            //Method method = c.getMethod("print",new Class[]{int.class,int.class})
            Method method = c.getMethod("print",int.class,int.class);
            //方法的反射操作
            //a1.print(10,20),方法的反射操作使用method对象来进行方法调用和a1.print()调用效果一样
            method.invoke(a1,new Object[]{10,20});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
class A{
    public void print(int a, int b){
        System.out.println(a + b);
    }
    public void print(String a, String b){
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }
}