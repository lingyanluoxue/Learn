package com.lylx.learn.gson

import com.google.gson.Gson

/**
 * inline + reified
 * 加上reified -- T 就可以像一个真实的类型去使用
 * 加上inline -- 要求代码在编译过程中真正的编译到调用的地方，传入的类型和返回的类型就确定
 * 传入的泛型要有一个上限：T : Any
 * reified 不是万能的，必须在调用他的时候传入一个确定的类型
 */
inline fun <reified T : Any> Gson.fromJson(json: String): T {
    return fromJson(json, T::class.java)
}

/**
 * 对于BaseModel<T>类型的
 */
//inline fun <reified T : Any> Gson.fromJson(json: String): T {
//    return fromJson(json, object : TypeToken<T>() {}.type)
//}