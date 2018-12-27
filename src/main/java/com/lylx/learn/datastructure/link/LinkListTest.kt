package com.lylx.learn.datastructure.link

class LinkListTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            insertAnDisplayLink()

//            findAndDeleteLink()

//            opeFirstLastLinkList()

//            opeLinkSortedList()

//            opeDoublyLinkList()

        }

        private fun opeDoublyLinkList() {
            val linkList = DoublyLinkList()
            linkList.insertFirst(0,"zero")
            linkList.insertFirst(1,"one")
            linkList.insertFirst(2,"two")

            linkList.insertLast(3,"three")
            linkList.insertLast(5,"five")
            linkList.insertLast(6,"six")

            linkList.displayForward()
            linkList.displayBackward()

            linkList.deleteFirst()
            linkList.deleteLast()
            linkList.deleteLink(5)

            linkList.displayForward()

            linkList.insertAfter(0,4,"four")
            linkList.insertAfter(1,10,"ten")

            linkList.displayForward()
        }

        private fun opeLinkSortedList() {
            val linkList = LinkSortedList()
            linkList.insert(5,"five")
            linkList.insert(7,"seven")

            linkList.displayLinkList()

            linkList.insert(10,"ten")
            linkList.insert(8,"eight")
            linkList.insert(0,"zero")

            linkList.displayLinkList()

            linkList.remove()

            linkList.displayLinkList()
        }

        private fun opeFirstLastLinkList() {
            val linkList = FirstLastLinkedList()
            linkList.insertFirst(1, "one")
            linkList.insertFirst(2, "two")
            linkList.insertFirst(3, "three")
            linkList.insertFirst(4, "four")

            linkList.displayLinkList()

            linkList.insertLast(5,"five")
            linkList.insertLast(6,"six")
            linkList.insertLast(7,"seven")

            linkList.displayLinkList()

            linkList.deleteFirst()
            linkList.deleteFirst()

            linkList.displayLinkList()
        }

        private fun findAndDeleteLink() {
            val linkTestList = LinkList()
            linkTestList.insertFirst(1, "one")
            linkTestList.insertFirst(2, "two")
            linkTestList.insertFirst(3, "three")
            linkTestList.insertFirst(4, "four")

            linkTestList.displayLinkList()
            val findLink = linkTestList.find(1)
            if (findLink != null) {
                println("found link with key 1:{${findLink.linkId},${findLink.linkName}}")
            } else {
                println("can't find link")
            }
            val deleteLink = linkTestList.delete(3)
            if (deleteLink != null) {
                println("deleted link with key 3:{${deleteLink.linkId},${deleteLink.linkName}}")
            } else {
                println("can't delete link")
            }
            linkTestList.displayLinkList()
        }

        private fun insertAnDisplayLink() {
            val linkList = LinkList()
            linkList.insertFirst(1, "one")
            linkList.insertFirst(2, "two")
            linkList.insertFirst(3, "three")
            linkList.insertFirst(4, "four")

            linkList.displayLinkList()

            while (!linkList.isEmpty()) {
                val deleteLink = linkList.deleteFirst()
                print("delete: ")
                deleteLink?.displayLink()
                println("")
            }
            linkList.displayLinkList()
        }
    }
}