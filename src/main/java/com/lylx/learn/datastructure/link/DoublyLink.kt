package com.lylx.learn.datastructure.link

/**
 * 双向链表链结点
 */
data class DoublyLink(val linkId: Int, val linkName: String) {
    var nextLink: DoublyLink? = null
    var previousLink: DoublyLink? = null

    fun displayLink() {
        print("Link{$linkId,$linkName} ")
    }
}