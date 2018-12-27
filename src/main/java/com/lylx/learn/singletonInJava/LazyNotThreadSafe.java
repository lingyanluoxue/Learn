package com.lylx.learn.singletonInJava;

/**
 * 懒汉式，线程不安全
 */
public class LazyNotThreadSafe {
    private static LazyNotThreadSafe INSTANCE;

    private LazyNotThreadSafe(){}

    public static LazyNotThreadSafe getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazyNotThreadSafe();
        }
        return INSTANCE;
    }
}
