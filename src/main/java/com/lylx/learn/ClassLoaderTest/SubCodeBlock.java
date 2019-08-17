package com.lylx.learn.ClassLoaderTest;

/**
 * 执行顺序：
 * 1. 父类静态代码块
 * 2. 子类静态代码块
 * 3. 父类构造代码块
 * 4. 父类构造函数
 * 5. 子类构造代码块
 * 6. 子类构造函数
 */
public class SubCodeBlock extends SuperCodeBlock{
    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类构造代码块");
    }

    public SubCodeBlock() {
        System.out.println("子类构造函数");
    }

    public static void main(String[] args) {
        SubCodeBlock sb = new SubCodeBlock();
        System.out.println("------------");
        SubCodeBlock sb1 = new SubCodeBlock();

//        父类静态代码块
//        子类静态代码块
//        父类构造代码块
//        父类构造函数
//        子类构造代码块
//        子类构造函数
//        ------------
//        父类构造代码块
//        父类构造函数
//        子类构造代码块
//        子类构造函数
    }
}
