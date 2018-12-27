package com.lylx.learn.tailrec

import java.math.BigInteger

/**
 * https://www.zhihu.com/question/20761771
 *
 * 尾递归
 */

/**
 * 阶乘
 *
 */
//当num=10000 ，就会抛异常StackOverflowError
fun factorial(num: Int): BigInteger {
    if (num == 0) return BigInteger.valueOf(1L)
    return BigInteger.valueOf(num.toLong()).times(factorial(num - 1))
}

/**
 * 使用尾递归实现阶乘
 */
class Result(var value: BigInteger = BigInteger.valueOf(1L))

tailrec fun factorial(num: Int, result: Result) {
    if (num == 0) result.value = result.value.times(BigInteger.valueOf(1L))
    else {
        result.value = result.value.times(BigInteger.valueOf(num.toLong()))
        factorial(num - 1, result)
    }
}

fun main(args: Array<String>) {
//    println(factorial(6))
    //抛异常StackOverflowError
//    println(factorial(10000))

    val result = Result()
    factorial(10000, result)
    println(result.value)

}

