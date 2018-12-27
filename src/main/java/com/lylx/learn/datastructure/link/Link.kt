package com.lylx.learn.datastructure.link

data class Link(val linkId: Int, val linkName: String) {
    var nextLink: Link? = null

    fun displayLink() {
        print("Link{$linkId,$linkName} ")
    }
}