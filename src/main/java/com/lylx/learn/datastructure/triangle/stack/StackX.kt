package com.lylx.learn.datastructure.triangle.stack

class StackX(maxSize: Int) {
    private val stackArray: Array<Param?> = arrayOfNulls(maxSize)
    private var top: Int = -1

    /**
     * put item on top of stack
     */
    fun push(pushValue: Param) {
        stackArray[++top] = pushValue
    }

    /**
     * take item from top of stack
     */
    fun pop(): Param? {
        return stackArray[top--]
    }

    /**
     * peek at top of stack
     */
    fun peek(): Param? {
        return stackArray[top]
    }
}
