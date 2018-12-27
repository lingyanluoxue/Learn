package com.lylx.learn.datastructure.triangle


/**
 * 递归
 */
fun main(args: Array<String>) {
//    println(rabbitTriangle(30))
    println(power(2, 5))
    println(combination(6, 3))
}

/**
 * 一列数的规则如下：1、1、2、3、5、8、13、21、34，第30位数是多少
 * 兔子问题
 */
fun rabbitTriangle(num: Int): Int {
    return if (num == 1 || num == 2) {
        1
    } else {
        rabbitTriangle(num - 1) + rabbitTriangle(num - 2)
    }
}

/**
 * 乘方
 * 核心思想是：x^y=(x^2)^(y/2)
 */
fun power(x: Int, y: Int): Int {
    return when {
        y == 1 -> x
        y % 2 == 1 -> x * power(x * x, y / 2)
        else -> power(x * x, y / 2)
    }
}

private val weights: IntArray = intArrayOf(11, 8, 7, 6, 5)
private var backpackArray = arrayListOf<Int>()

fun backpack() {
    loop@ for (index in 0 until weights.size) {
        var totalWeight = 20
        backpackArray.clear()
        var currentIndex = index
        while (currentIndex < weights.size) {
            if (totalWeight - weights[currentIndex] >= 0) {
                backpackArray.add(weights[currentIndex])
                println("$totalWeight --- ${weights[currentIndex]}")
                totalWeight -= weights[currentIndex]
            }
            if (totalWeight == 0) {
                println("success")
                break@loop
            }
            currentIndex++
        }
    }
    println("backpackArray: $backpackArray")
}

/**
 * 组合
 */
fun combination(num: Int, selectNum: Int): Int {
    return when {
        num == selectNum -> 1
        selectNum == 1 -> num
        else -> combination(num - 1, selectNum - 1) + combination(num - 1, selectNum)
    }

}
