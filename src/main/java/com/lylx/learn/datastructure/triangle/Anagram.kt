package com.lylx.learn.datastructure.triangle

/**
 * 变位字：递归实现排列
 */
private var size: Int = 0
private var count: Int = 0
private var argChar = arrayOf<String>()

fun main(args: Array<String>) {
    size = args.size
    argChar = args.copyOf()

    doAnagram(size)
}

fun doAnagram(newSize: Int) {
    if (newSize == 1) {
        return
    }
    for (j in 0 until newSize) {
        doAnagram(newSize - 1)
        if (newSize == 2) {
            displayWord()
        }
        rotate(newSize)
    }
}

fun displayWord() {
    if (count < 99) {
        print(" ")
    }
    if (count < 9) {
        print(" ")
    }
    print("${++count}:")
    argChar.forEach {
        print(it)
    }
    print("   ")
    if (count % 6 == 0) {
        println("")
    }
}

fun rotate(newSize: Int) {
    val position = size - newSize
    val temp = argChar[position]
    for (index in position + 1 until size) {
        argChar[index - 1] = argChar[index]
    }
    argChar[size - 1] = temp
}



