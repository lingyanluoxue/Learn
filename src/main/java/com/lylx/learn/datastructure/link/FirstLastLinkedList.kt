package com.lylx.learn.datastructure.link

/**
 * 双端链表
 */
class FirstLastLinkedList {

    private var first: Link? = null
    private var last: Link? = null

    fun isEmpty(): Boolean = first == null

    fun insertFirst(id: Int, name: String) {
        val newLink = Link(id, name)
        if (isEmpty()) {
            last = newLink
        }
        //newLink --> old first
        newLink.nextLink = first
        //first --> newLink
        first = newLink
    }

    fun insertLast(id: Int, name: String) {
        val newLink = Link(id, name)
        if (isEmpty()) {
            first = newLink
        } else {
            last?.nextLink = newLink
        }
        last = newLink
    }

    fun deleteFirst(): Link? {
        val temp = first
        if (first?.nextLink==null){
            last = null
        }
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