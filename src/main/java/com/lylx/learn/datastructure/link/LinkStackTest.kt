package com.lylx.learn.datastructure.link

class LinkStackTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val linkStack = LinkStack()
            linkStack.push(0, "zero")
            linkStack.push(1, "one")
            linkStack.push(2, "two")

            linkStack.displayStack()

            linkStack.push(3, "three")
            linkStack.push(4, "four")
            linkStack.push(5, "five")

            linkStack.displayStack()

            linkStack.pop()
            linkStack.pop()

            linkStack.displayStack()
        }
    }
}