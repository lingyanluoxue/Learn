package com.lylx.learn.datastructure.triangle

/**
 * 归并排序
 */
fun main(args: Array<String>) {
    mergeSortTest()

//    val arrayA = intArrayOf(23, 47, 81, 95)
//    val arrayB = intArrayOf(7, 14, 39, 55, 62, 74)
//    var arrayC = IntArray(10)
//    merge(arrayA, arrayA.size, arrayB, arrayB.size, arrayC)
//    display(arrayC)
}

fun mergeSortTest() {
    val mergeSortArray = MergeSortArray(12)
    mergeSortArray.insert(64)
    mergeSortArray.insert(21)
    mergeSortArray.insert(33)
    mergeSortArray.insert(70)
    mergeSortArray.insert(12)
    mergeSortArray.insert(85)
    mergeSortArray.insert(44)
    mergeSortArray.insert(3)
    mergeSortArray.insert(99)
    mergeSortArray.insert(0)
    mergeSortArray.insert(108)
    mergeSortArray.insert(36)

    mergeSortArray.display()

    mergeSortArray.mergeSort()

    mergeSortArray.display()
}

fun display(array: IntArray) {
    array.forEach {
        print("$it ")
    }
    println("")
}

fun merge(arrayA: IntArray, sizeA: Int, arrayB: IntArray, sizeB: Int, arrayC: IntArray) {
    var aIndex = 0
    var bIndex = 0
    var cIndex = 0
    while (aIndex < sizeA && bIndex < sizeB) {
        if (arrayA[aIndex] < arrayB[bIndex]) {
            arrayC[cIndex++] = arrayA[aIndex++]
        } else {
            arrayC[cIndex++] = arrayB[bIndex++]
        }
    }
    while (aIndex < sizeA) {
        arrayC[cIndex++] = arrayA[aIndex++]
    }
    while (bIndex < sizeB) {
        arrayC[cIndex++] = arrayB[bIndex++]
    }
}