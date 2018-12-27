package com.lylx.learn.datastructure.link

/**
 * 用链表实现栈
 */
class LinkStack {
    private var linkList: LinkList = LinkList()

    fun push(id: Int, name: String) {
        linkList.insertFirst(id, name)
    }

    fun pop(): Link? {
        return linkList.deleteFirst()
    }

    fun isEmpty(): Boolean {
        return linkList.isEmpty()
    }

    fun displayStack(){
        print("Stack(top——>bottom)")
        linkList.displayLinkList()
    }
}