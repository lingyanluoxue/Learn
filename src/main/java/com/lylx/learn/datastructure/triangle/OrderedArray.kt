package com.lylx.learn.datastructure.triangle

/**
 * 递归实现二分查找--有序数组：查找、插入、删除
 */
class OrderedArray(max: Int) {
    private val a: LongArray = LongArray(max)
    private var mElems: Int = 0

    fun size(): Int {
        return mElems
    }

    /**
     * 二分查找
     */
    fun find(searchValue: Long): Int {
        return reFind(searchValue, 0, mElems - 1)
    }

    fun reFind(searchValue: Long, lowerBound: Int, upperBound: Int): Int {
        val curIn = (lowerBound + upperBound) / 2
        return if (a[curIn] == searchValue) {
            curIn
        } else if (lowerBound > upperBound) {
            mElems
        } else {
            if (a[curIn] < searchValue) {
                reFind(searchValue, curIn + 1, upperBound)
            } else {
                reFind(searchValue, lowerBound, curIn - 1)
            }
        }
    }

    /**
     * 线性插入
     */
    fun insert(insertValue: Long) {
        var j = 0
        while (j < mElems) {
            if (a[j] > insertValue) {
                break
            }
            j++
        }
        for (k in mElems downTo j + 1) {
            a[k] = a[k - 1]
        }
        a[j] = insertValue
        mElems++
    }

    fun delete(deleteValue: Long): Boolean {
        val j = find(deleteValue)
        return if (j == mElems) {
            false
        } else {
            for (k in j until mElems) {
                a[k] = a[k + 1]
            }
            mElems--
            true
        }
    }

    fun display() {
        for (j in 0 until mElems) {
            print(a[j].toString() + " ")
        }
        println("")
    }
}
