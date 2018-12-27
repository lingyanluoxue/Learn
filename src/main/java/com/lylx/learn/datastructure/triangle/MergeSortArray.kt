package com.lylx.learn.datastructure.triangle

/**
 * 归并排序
 */
class MergeSortArray(max: Int) {
    private val theArray: LongArray = LongArray(max)
    private var mElems: Int = 0

    fun insert(insertValue: Long) {
        theArray[mElems] = insertValue
        mElems++
    }

    fun display() {
        theArray.forEach {
            print("$it ")
        }
        println("")
    }

    fun mergeSort() {
        val workSpace = LongArray(mElems)
        recMergeSort(workSpace, 0, mElems - 1)
    }

    private fun recMergeSort(workSpace: LongArray, lowerBound: Int, upperBound: Int) {
        if (lowerBound == upperBound) {
            return
        } else {
            val mid = (lowerBound + upperBound) / 2
            recMergeSort(workSpace, lowerBound, mid)
            recMergeSort(workSpace, mid + 1, upperBound)
            merge(workSpace, lowerBound, mid + 1, upperBound)
        }
    }

    private fun merge(workSpace: LongArray, lowPtr: Int, hightPtr: Int, upperBound: Int) {
        var index = 0
        var lowIndex = lowPtr
        var hightIndex = hightPtr
        val lowerBound = lowPtr
        val mid = hightPtr - 1
        val rangeNum = upperBound - lowerBound + 1

        while (lowIndex <= mid && hightIndex <= upperBound) {
            if (theArray[lowIndex] < theArray[hightIndex]) {
                workSpace[index++] = theArray[lowIndex++]
            } else {
                workSpace[index++] = theArray[hightIndex++]
            }
        }

        while (lowIndex <= mid) {
            workSpace[index++] = theArray[lowIndex++]
        }
        while (hightIndex <= upperBound) {
            workSpace[index++] = theArray[hightIndex++]
        }

        for (rangeIndex in 0 until rangeNum) {
            theArray[lowerBound + rangeIndex] = workSpace[rangeIndex]
        }
    }
}

