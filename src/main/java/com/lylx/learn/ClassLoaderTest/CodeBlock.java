package com.lylx.learn.ClassLoaderTest;

/**
 * 执行顺序
 * 1. 静态代码块
 * 2. 构造代码块
 * 3. 构造函数
 * 4. 普通代码块　
 */
public class CodeBlock {

    /**
     * 静态代码块
     * 在类被加载的时候就运行了，而且只运行一次，并且优先于各种代码块以及构造函数
     * 一个类中有多个静态代码块，会按照书写顺序依次执行
     * 静态代码块不能存在任何方法体中
     * 静态代码块不能访问普通变量
     */
    static{
        System.out.println("静态代码块");
    }

    /**
     *  构造代码块 ：在 java 类中使用 {} 声明的代码块
     *  在类中定义
     *  在创建对象时被调用，每次创建对象都会调用一次，但是优先于构造函数执行
     */
    {
        System.out.println("构造代码块");
    }

    public CodeBlock(){
        System.out.println("无参构造函数");
    }

    public CodeBlock(String str){
        System.out.println("有参构造函数");
    }

    /**
     * 普通代码块：在方法体中定义的，普通代码块的执行顺序和书写顺序一致
     * 普通方法，内含普通代码块
     */
    public void sayHello(){
        {
            System.out.println("普通代码块");
        }
    }

    public static void main(String[] args) {
        System.out.println("执行了main方法");
        System.out.println("---------------");
        new CodeBlock().sayHello();
        System.out.println("---------------");
        new CodeBlock().sayHello();

//        静态代码块
//        执行了main方法
//        ---------------
//        构造代码块
//        无参构造函数
//        普通代码块
//        ---------------
//        构造代码块
//        无参构造函数
//        普通代码块
    }
}
