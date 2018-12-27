package com.lylx.learn.datastructure.link

/**
 * 单链表
 */
class LinkList {
    private var first: Link? = null

    fun isEmpty(): Boolean = first == null

    fun insertFirst(id: Int, name: String) {
        val newLink = Link(id, name)
        //newLink --> old first
        newLink.nextLink = first
        //first --> newLink
        first = newLink
    }

    fun deleteFirst(): Link? {
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

    fun find(findLinkId: Int): Link? {
        var currentLink = first
        while (currentLink?.linkId != findLinkId) {
            if (currentLink?.nextLink == null) {
                return null
            } else {
                currentLink = currentLink.nextLink
            }
        }
        return currentLink
    }

    fun delete(deleteLinkId: Int): Link? {
        var currentLink = first
        var previousLink = first
        while (currentLink?.linkId != deleteLinkId) {
            if (currentLink?.nextLink == null) {
                return null
            } else {
                previousLink = currentLink
                currentLink = currentLink.nextLink
            }
        }
        if (currentLink == first) {
            first = first?.nextLink
        } else {
            previousLink?.nextLink = currentLink.nextLink
        }
        return currentLink
    }
}