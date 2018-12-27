package com.lylx.learn.datastructure.triangle

/**
 * 汉诺塔问题
 */
fun main(args: Array<String>) {
    doTowers(3, "A", "B", "C")
}

fun doTowers(topN: Int, from: String, inter: String, to: String) {
    if (topN == 1) {
        println("Disk 1 from $from to $to")
    } else {
        // from -> inter
        doTowers(topN - 1, from, to, inter)
        println("Disk $topN from $from to $to")
        // inter -> to
        doTowers(topN - 1, inter, from, to)
    }
}