package com.lylx.learn.enum

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

/**
 * 一个枚举类可以实现接口（但不能从类继承），可以为所有条目提供统一的接口成员实现，
 * 也可以在相应匿名类中为每个条目提供各自的实现。只需将接口添加到枚举类声明中即可
 */
enum class IntArithmetic : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}