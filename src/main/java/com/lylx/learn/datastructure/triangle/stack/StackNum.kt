package com.lylx.learn.datastructure.triangle.stack


class StackNum(maxSize: Int) {
    private val stackArray: IntArray = IntArray(maxSize)
    private var top: Int = -1

    /**
     * put item on top of stack
     */
    fun push(pushValue: Int) {
        stackArray[++top] = pushValue
    }

    /**
     * take item from top of stack
     */
    fun pop(): Int {
        return stackArray[top--]
    }

    /**
     * peek at top of stack
     */
    fun peek(): Int {
        return stackArray[top]
    }

    /**
     * true if stack is empty
     */
    fun isEmpty(): Boolean {
        return top == -1
    }
}
