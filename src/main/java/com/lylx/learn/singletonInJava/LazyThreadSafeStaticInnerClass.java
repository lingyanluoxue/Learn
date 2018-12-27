package com.lylx.learn.singletonInJava;

/**
 * 静态内部类的方式：
 * 懒加载：类加载的时候并没有初始化instance（加载类的时候并没有加载holder，没有加载holder就不会初始化holder的静态成员）
 * 线程安全：第一次调用getInstance的时候，holder第一次被访问到，holder会被类加载，类加载过程是一个线程安全操作（相当于线程安全的工作丢给虚拟机类加载的时候保证）
 */
public class LazyThreadSafeStaticInnerClass {

    private static class Holder{
        private static LazyThreadSafeStaticInnerClass INSTANCE = new LazyThreadSafeStaticInnerClass();
    }

    private LazyThreadSafeStaticInnerClass(){}

    public static LazyThreadSafeStaticInnerClass getInstance(){
        return Holder.INSTANCE;
    }
}
