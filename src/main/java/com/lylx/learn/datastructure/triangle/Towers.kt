package com.lylx.learn.datastructure.triangle

/**
 * 汉诺塔问题
 *
 * 1. 从塔座S（源塔座）移动包含上面的n-1个盘子的子树到塔座I（中介塔座）上
 * 2. 从塔座S移动剩余的盘子（最大的盘子）到塔座D（目标塔座）上
 * 3. 从塔座I移动子树到塔座D
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