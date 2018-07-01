package com.ysla.reflect;

import java.lang.reflect.Method;

public class ClassUtil {

    public static void printClassMessage(Object obj) {
        Class c = obj.getClass();
        //获取类的名称
        System.out.println("类的名称是:"+c.getName());
        /**
         * Method类,方法对象
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取的是所有的public的函数,包括父类继承而来的
         * getDeclaredMethods()获取该类自己自己声明的方法,不问访问权限
         */
        Method[] ms = c.getMethods();
        for (int i = 0; i < ms.length; i++) {
            Method m = ms[i];
            //得到方法的返回值类型的类类型
            Class returnType = m.getReturnType();
            System.out.print(returnType.getName() + " ");
            //得到方法名称
            System.out.print(m.getName() + "(");
            //获取参数类型-->得到参数列表的类型的类类型
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                Class paramType = paramTypes[j];
                System.out.print(paramType.getName() + ",");
            }
            System.out.println(")");
        }


    }

}
