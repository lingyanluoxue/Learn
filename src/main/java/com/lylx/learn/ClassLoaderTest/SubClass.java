package com.lylx.learn.ClassLoaderTest;

/**
 * 执行顺序：
 * 1. 父类静态变量、静态代码块
 * 2. 子类静态变量、静态代码块
 * 3. 父类非静态变量、非静态代码块
 * 4. 父类构造函数
 * 5. 子类非静态变量、非静态代码块
 * 6. 子类构造函数
 */
public class SubClass extends Parent {
    /**
     * 静态代码块是在类加载时自动执行的，非静态代码块是在创建对象时自动执行的代码，
     * 不创建对象不执行该类的非静态代码块。且执行顺序为:
     * 静态代码块---非静态代码块---构造函数。
     * <p>
     * 静态代码块是自动执行的;  静态方法是被调用的时候才执行的.
     * 静态代码块可用来初始化一些项目最常用的变量或对象;
     * 静态方法可用作不创建对象也可能需要执行的代码
     */

    // 静态变量
    public static String s_StaticField = "子类--静态变量";

    // 变量
    public String s_Field = "子类--变量";

    // 静态代码块
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态代码块");
    }

    // 构造代码块
    {
        System.out.println(s_Field);
        System.out.println("子类--构造代码块");
    }

    // 构造函数
    public SubClass() {
        System.out.println("子类--构造函数");
    }

    // 程序入口
    public static void main(String[] args) {
        new SubClass();
    }
}
