package com.lylx.learn.ClassLoaderTest;

/**
 * 执行顺序：
 * 1. 静态变量、静态代码块
 * 2. 非静态变量、非静态代码块/构造代码块
 * 3. 构造函数
 * 4. 普通代码块、普通方法
 */
public class SimpleTest {
    //一个静态变量
    private static int a = 10;

    //一个普通变量
    private int b = 20;

    // 无参构造函数
    public SimpleTest() {
        System.out.println("无参构造函数, a=" + a + ", b=" + b);
        b = b + 1;
    }

    // 构造代码块 ：在 java 类中使用 {} 声明的代码块
    {
        System.out.println("构造代码块, a=" + a + ", b=" + b);
        a = a + 1;
    }

    /**
     * 静态代码块
     * 在类被加载的时候就运行了，而且只运行一次，并且优先于各种代码块以及构造函数
     * 一个类中有多个静态代码块，会按照书写顺序依次执行
     * 静态代码块不能存在任何方法体中
     * 静态代码块不能访问普通变量
     */
    static {
        System.out.println("静态代码块, a = " + a);
    }

    /**
     * 普通代码块：在方法体中定义的
     * 普通方法，其中包含一个普通代码块
     */
    public void say() {
        {
            System.out.println("普通代码块, a=" + a + ", b=" + b);
        }
    }

    /**
     * 普通方法
     */
    public void show() {
        System.out.println("普通方法, a=" + a + ", b=" + b);
    }

    public static void main(String[] args) {
        System.out.println("执行了main方法");
        System.out.println("---------------");

        SimpleTest simple = new SimpleTest();
        simple.say();
        System.out.println("---------------");
        SimpleTest test = new SimpleTest();
        test.show();

//        静态代码块, a = 10
//        执行了main方法
//        ---------------
//        构造代码块, a=10, b=20
//        无参构造函数, a=11, b=20
//        普通代码块, a=11, b=21
//        ---------------
//        构造代码块, a=11, b=20
//        无参构造函数, a=12, b=20
//        普通方法, a=12, b=21
    }
}
