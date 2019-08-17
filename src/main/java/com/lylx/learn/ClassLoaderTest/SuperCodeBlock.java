package com.lylx.learn.ClassLoaderTest;

public class SuperCodeBlock {

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类构造代码块");
    }

    public SuperCodeBlock() {
        System.out.println("父类构造函数");
    }
}
