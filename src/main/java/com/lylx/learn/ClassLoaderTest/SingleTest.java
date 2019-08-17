package com.lylx.learn.ClassLoaderTest;

/**
 * 执行顺序：
 * 1. 静态变量,静态代码块
 *    a. 顺序执行，谁先声明谁先执行
 *    b. 静态变量为创建当前类实例对象，依次执行：非静态变量，构造代码块，构造函数
 * 3. 非静态变量，构造代码块
 * 4. 构造函数
 */
public class SingleTest {
    /**
     * 顺序执行，先执行 k = 0
     *
     * 静态变量：用于计数
     */
    public static int k = 0;
    /**
     * 创建实例对象过程中，从此类的第一行开始，不会执行静态资源，
     * 会执行非静态变量，非静态代码块/构造代码块，构造函数
     *
     * 创建 t1 ,会依次执行 j = print("j") ，构造代码块，构造函数：
     * 1. print: 1{j    i=0    n=0}
     * 2. print: 2{构造代码块    i=1    n=1}
     * 3. 构造函数: 3{t1    i=2    n=2}
     */
    public static SingleTest t1 = new SingleTest("t1");
    // 创建 t2 ,同理，依次执行 j = print("j")，构造代码块，构造函数
    public static SingleTest t2 = new SingleTest("t2");
    // 静态变量
    public static int i = print("i");
    // 静态变量 n = 99
    public static int n = 99;
    // 非静态变量
    public int j = print("j");

    // 构造代码块
    {
        print("构造代码块");
    }

    // 静态代码块
    static {
        print("静态代码块");
    }

    /**
     * 构造方法
     */
    public SingleTest(String str) {
        System.out.println("构造函数: " + (++k) + "{" + str + "    i=" + i + "    n=" + n + "}");
        ++i;
        ++n;
    }

    public static int print(String str) {
        System.out.println("print: " + (++k) + "{" + str + "    i=" + i + "    n=" + n + "}");
        ++n;
        return ++i;
    }

    public static void main(String[] args) {
        SingleTest singleTest = new SingleTest("init");

//        print: 1{j    i=0    n=0}
//        print: 2{构造代码块    i=1    n=1}
//        构造函数: 3{t1    i=2    n=2}
//        print: 4{j    i=3    n=3}
//        print: 5{构造代码块    i=4    n=4}
//        构造函数: 6{t2    i=5    n=5}
//        print: 7{i    i=6    n=6}
//        print: 8{静态代码块    i=7    n=99}
//        print: 9{j    i=8    n=100}
//        print: 10{构造代码块    i=9    n=101}
//        构造函数: 11{init    i=10    n=102}
    }
}
