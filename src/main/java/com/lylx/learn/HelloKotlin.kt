package com.lylx.learn

import com.lylx.learn.model.User
import rx.Observable
import java.io.File

fun main(args: Array<String>) {
//    println("hello world!")

//    val user = User(0, "lylx")
//    println(user)

    val list = arrayListOf<User>()
    list.add(User(0, "lylx"))
    list.add(User(0, "lylx"))
    println("size:${list.size}---$list")

//    traverse(args)

//    consoleParam(args)

//    useLambda()

//    useNum()

//    useTrimMargin()

//    usePriceUnit()

//    useBreak()

//    useContinue()

//    useLabel()

//    count = 9
//    println(count)
//    count = -1
//    println(count)


}


/**
 * 幕后字段
 * 在 Kotlin 类中不能直接声明字段。然而，当一个属性需要一个幕后字段时，Kotlin 会自动提供。这个幕后字段可以使用field标识符在访问器中引用
 * field 标识符只能用在属性的访问器内
 */
var count = 0
    set(value) {
        field = if (value > 0) value
        else 0
    }

fun useBreak() {
    for (i in 1..10) {
        for (j in 1..10) {
            if (j == 5) break
            println("j:$j")
        }
        println("i:$i")
    }
}

fun useContinue() {
    for (i in 1..10) {
        for (j in 1..10) {
            if (j == 5) continue
            println("j:$j")
        }
        println("i:$i")
    }
}

fun useLabel() {
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (j == 5) break@loop
            println("j:$j")
        }
        println("i:$i")
    }

    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (j == 5) continue@loop
            println("j:$j")
        }
        println("i:$i")
    }

    run loop@ {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // 从传入 run 的 lambda 表达式非局部返回
            print(it)
        }
    }
    print(" done with nested loop")
}

fun usePriceUnit() {
    val price = """
${'$'}9.99
"""
    println(price)
}

/**
 * 通过 trimMargin() 函数去除前导空格：默认| 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")
 */
fun useTrimMargin() {
    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println(text)
}


/**
 *  数字装箱保留了相等性，不必保留同一性
 */
fun useNum() {
    val a: Int = 10000
    println(a === a) // 输出“true”
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA) // ！！！输出“false”！！！

    val b: Int = 10000
    println(b == b) // 输出“true”
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b
    println(boxedB == anotherBoxedB) // 输出“true”
}


/**
 * 遍历:map
 */
fun traverse(args: Array<String>) {
//    args.map {
//        println(it)
//    }

    args.map(::println)

//    for (arg in args){
//        println(arg)
//    }
}

/**
 * a_b_c d_e_f g_h_i_j
 * a b c d e f g h i j
 *
 * 遍历:flatMap
 */
fun consoleParam(args: Array<String>) {
    args.flatMap {
        it.split("_")
    }.map {
        print("$it ")
    }
}

/**
 * kotlin中lambda表达式使用
 */
fun useLambda() {
    val text = File(ClassLoader.getSystemResource("test").path).readText()
    Observable.from(text.toCharArray().asIterable())
            .filter { !it.isWhitespace() }
            .groupBy { it }
            .subscribe { group ->
                group.count().subscribe {
                    println("${group.key} -> $it")
                }
            }
}
