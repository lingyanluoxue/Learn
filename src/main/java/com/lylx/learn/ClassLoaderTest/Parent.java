package com.lylx.learn.ClassLoaderTest;

public class Parent {
    // 静态变量
    public static String p_StaticField = "父类--静态变量";
    // 变量
    public String p_Field = "父类--变量";

    // 静态代码块
    static {
        System.out.println(p_StaticField);
        System.out.println("父类--静态代码块");
    }

    // 构造代码块
    {
        System.out.println(p_Field);
        System.out.println("父类--构造代码块");
    }

    // 构造函数
    public Parent() {
        System.out.println("父类--构造函数");
    }
}
