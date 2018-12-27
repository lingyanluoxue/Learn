package com.lylx.learn.datastructure.link

/**
 * 用链表实现队列
 */
class LinkQueue {
    private var linkList: FirstLastLinkedList = FirstLastLinkedList()

    fun insert(id:Int,name:String) {
        linkList.insertLast(id, name)
    }

    fun remove(): Link? {
        return linkList.deleteFirst()
    }

    fun isEmpty(): Boolean {
        return linkList.isEmpty()
    }

    fun displayQueue(){
        print("Queue(front——>rear)")
        linkList.displayLinkList()
    }
}