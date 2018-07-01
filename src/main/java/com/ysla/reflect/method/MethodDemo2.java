package com.ysla.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo2 {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList<String> list1 = new ArrayList<String>();


        Class c1 = list.getClass();
        Class c2 = list1.getClass();

        System.out.println(c1 == c2);

        //反射操作都是编译后的操作

        /**
         * c1 == c2结果返回true说明编译后集合的泛型是去泛型化的
         * java中集合的泛型,是防止错误输入的,只在编译阶段有效
         * 绕过编译就无效了
         * 验证:通过方法的反射来操作,绕过编译
         */
        try {
            Method method = c1.getMethod("add",Object.class);
            method.invoke(list,10);
            System.out.println(list.size());
            System.out.println(list);
            //现在不能这样遍历,会有类型转换异常
            /*for (String s : list1) {
                System.out.println(s);
            }*/
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
