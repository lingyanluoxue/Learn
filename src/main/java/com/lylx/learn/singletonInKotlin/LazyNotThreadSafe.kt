package com.lylx.learn.singletonInKotlin

/**
 * 懒加载，线程不安全
 */
class LazyNotThreadSafe {

    companion object {
        val instance by lazy(LazyThreadSafetyMode.NONE) {
            LazyNotThreadSafe()
        }

        //下面是另一种等价的写法, 获取单例使用 get 方法
        private var INSTANCE: LazyNotThreadSafe? = null

        fun get(): LazyNotThreadSafe {
            if (INSTANCE == null) {
                INSTANCE = LazyNotThreadSafe()
            }
            return INSTANCE!!
        }
    }
}