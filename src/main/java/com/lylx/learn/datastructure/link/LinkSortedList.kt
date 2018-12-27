package com.lylx.learn.datastructure.link

/**
 * 有序链表
 */
class LinkSortedList {
    private var first: Link? = null

    fun isEmpty(): Boolean = first == null

    fun insert(id: Int, name: String) {
        val newLink = Link(id, name)
        var currentLink = first
        var previousLink: Link? = null

        while (currentLink != null && id > currentLink.linkId) {
            previousLink = currentLink
            currentLink = currentLink.nextLink
        }
        if (previousLink == null) {
            first = newLink
        } else {
            previousLink.nextLink = newLink
        }
        newLink.nextLink = currentLink
    }

    fun remove(): Link? {
        val temp = first
        first = first?.nextLink
        return temp
    }

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