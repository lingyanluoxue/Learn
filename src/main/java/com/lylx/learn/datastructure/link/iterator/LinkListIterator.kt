package com.lylx.learn.datastructure.link.iterator

import com.lylx.learn.datastructure.link.Link

class LinkListIterator(val linkList: LinkList) {

    private var current: Link? = null
    private var previous: Link? = null

    init {
        reset()
    }

    fun reset() {
        current = linkList.first
        previous = null
    }

    fun atEnd(): Boolean = current?.nextLink == null

    fun nextLink() {
        previous = current
        current = current?.nextLink
    }

    fun insertAfter(linkId: Int, linkName: String) {
        val newLink = Link(linkId, linkName)
        if (linkList.isEmpty()) {
            linkList.first = newLink
            current = newLink
        } else {
            newLink.nextLink = current?.nextLink
            current?.nextLink = newLink
            nextLink()
        }
    }

    fun insertBefore(linkId: Int, linkName: String) {
        val newLink = Link(linkId, linkName)
        if (previous == null) {
            newLink.nextLink = linkList.first
            linkList.first = newLink
            reset()
        } else {
            newLink.nextLink = previous?.nextLink
            previous?.nextLink = newLink
            current = newLink
        }
    }

    fun deleteCurrent(): Link? {
        if (previous == null) {
            linkList.first = current?.nextLink
            reset()
        } else {
            previous?.nextLink = current?.nextLink
            if (atEnd()) {
                reset()
            } else {
                current = current?.nextLink
            }
        }
        return current
    }
}