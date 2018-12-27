package com.lylx.learn.datastructure.link

class LinkQueueTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val linkQueue = LinkQueue()
            linkQueue.insert(0, "zero")
            linkQueue.insert(1, "one")
            linkQueue.insert(2, "two")

            linkQueue.displayQueue()

            linkQueue.insert(3, "three")
            linkQueue.insert(4, "four")
            linkQueue.insert(5, "five")

            linkQueue.displayQueue()

            linkQueue.remove()
            linkQueue.remove()

            linkQueue.displayQueue()
        }
    }
}