package com.lylx.learn.datastructure.link

/**
 * 双向链表
 */
class DoublyLinkList {

    private var first: DoublyLink? = null
    private var last: DoublyLink? = null

    fun isEmpty(): Boolean = first == null

    fun insertFirst(id: Int, name: String) {
        val newLink = DoublyLink(id, name)
        if (isEmpty()) {
            last = newLink
        } else {
            first?.previousLink = newLink
        }
        //newLink --> old first
        newLink.nextLink = first
        //first --> newLink
        first = newLink
    }

    fun insertLast(id: Int, name: String) {
        val newLink = DoublyLink(id, name)
        if (isEmpty()) {
            first = newLink
        } else {
            last?.nextLink = newLink
            newLink.previousLink = last
        }
        last = newLink
    }

    fun insertAfter(currentId: Int, id: Int, name: String): Boolean {
        var current = first
        while (current?.linkId != currentId) {
            current = current?.nextLink
            if (current == null) {
                return false
            }
        }
        val newLink = DoublyLink(id, name)
        if (current == last) {
            newLink.nextLink = null
            last = newLink
        } else {
            newLink.nextLink = current.nextLink
            current.nextLink?.previousLink = newLink
        }
        newLink.previousLink = current
        current.nextLink = newLink
        return true
    }

    fun deleteFirst(): DoublyLink? {
        val temp = first
        if (first?.nextLink == null) {
            last = null
        } else {
            first?.nextLink?.previousLink = null
        }
        first = first?.nextLink
        return temp
    }

    fun deleteLast(): DoublyLink? {
        val temp = last
        if (first?.nextLink == null) {
            first = null
        } else {
            last?.previousLink?.nextLink = null
        }
        last = last?.previousLink
        return temp
    }

    fun deleteLink(deleteLinkId: Int): DoublyLink? {
        var current = first
        while (current?.linkId != deleteLinkId) {
            current = current?.nextLink
            if (current == null) {
                return null
            }
        }
        if (current == first) {
            first = current.nextLink
        } else {
            current.previousLink?.nextLink = current.nextLink
        }
        if (current == last) {
            last = current.previousLink
        } else {
            current.nextLink?.previousLink = current.previousLink
        }
        return current
    }

    fun displayForward() {
        print("DoublyLinkList (first-->last):")
        var current = first
        while (current != null) {
            current.displayLink()
            current = current.nextLink
        }
        println("")
    }

    fun displayBackward() {
        print("DoublyLinkList (last-->first):")
        var current = last
        while (current != null) {
            current.displayLink()
            current = current.previousLink
        }
        println("")
    }
}