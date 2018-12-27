package com.lylx.learn.datastructure.link.iterator

import com.lylx.learn.datastructure.link.Link

/**
 * 单链表
 */
class LinkList {
    var first: Link? = null

    fun isEmpty(): Boolean = first == null

    fun displayLinkList() {
        print("LinkList(first——>last)")
        var currentLink = first
        while (currentLink != null) {
            currentLink.displayLink()
            currentLink = currentLink.nextLink
        }
        println("")
    }
}