package com.lylx.learn.singletonInJava;

/**
 * 懒汉式，线程安全：同步锁（开销大）
 */
public class LazyThreadSafeSynchronized {
    private static LazyThreadSafeSynchronized INSTANCE;

    private LazyThreadSafeSynchronized(){}

    public static synchronized LazyThreadSafeSynchronized getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazyThreadSafeSynchronized();
        }
        return INSTANCE;
    }
}
