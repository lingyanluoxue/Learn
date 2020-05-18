package com.lylx.learn.singletonInKotlin


class LazyThreadSafeStaticInnerObject private constructor(){
    companion object{
        fun getInstance() = Holder.instance
    }

    private object Holder{
        val instance = LazyThreadSafeStaticInnerObject()
    }
}