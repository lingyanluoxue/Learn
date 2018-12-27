package com.lylx.learn.datastructure.triangle.stack

private lateinit var theStack: StackX
private var codePart: Int = 1
private var theAnswer: Int = 0
private var param: Param? = null
private var num = 0

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        num = args[0].toInt()
//        recTriangle()
        stackTriangle()
        println("$theAnswer")
    }
}

fun stackTriangle() {
    val theStack = StackNum(num)
    theAnswer = 0
    while (num > 0) {
        theStack.push(num--)
    }
    while (!theStack.isEmpty()) {
        theAnswer += theStack.pop()
    }
}

fun recTriangle() {
    theStack = StackX(num)
    codePart = 1
    while (!step()) {

    }
}

fun step(): Boolean {
    when (codePart) {
        1 -> {
            param = Param(num, 6)
            theStack.push(param!!)
            codePart = 2
        }
        2 -> {
            if (::theStack.isInitialized) {
                param = theStack.peek()
                if (param?.n == 1) {
                    theAnswer = 1
                    codePart = 5
                } else {
                    codePart = 3
                }
            }
        }
        3 -> {
            param = Param((param?.n ?: 0) - 1, 4)
            theStack.push(param!!)
            codePart = 2
        }
        4 -> {
            param = theStack.peek()
            theAnswer += param?.n ?: 0
            codePart = 5
        }
        5 -> {
            param = theStack.peek()
            codePart = param?.returnAddress ?: 0
            theStack.pop()
        }
        6 -> {
            return true
        }
    }
    return false
}

