package com.lylx.learn.datastructure.array;

/**
 * 有序数组：查找、插入、删除
 */
public class OrderedArray {
    private long[] a;
    private int nElems;

    public OrderedArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    /**
     * 二分查找
     * curIn 查找范围内的中间值
     * lowBound 查找范围内第一个数据项
     * upperBound 查找范围内最后一个数据项
     * 每循环一次，将查找范围缩小一半
     *
     * 1. 循环查找，获取查找范围中间值
     * 2. 查看 curIn 是否指向查找所需数据项，是则返回，退出循环
     *    比较 lowerBound 和 upperBound 大小，若 lowerBound > upperBound ,表明查找范围无效，停止查找，未找到查找所需数据项
     *    范围足够大，需将范围缩小一半：比较范围中间值 a[curIn] 和与所查数据项值 searchValue 大小
     *        a. a[curIn] < searchValue ,将查找范围设为当前范围后半部，即置 lowerBound = curIn + 1
     *        b. a[curIn] > searchValue，将查找范围设为当前范围前半部，即置 upperBound = curIn - 1
     */
    public int find(long searchValue) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchValue) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (a[curIn] < searchValue) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    /**
     * 线性插入
     */
    public void insert(long insertValue) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] > insertValue) {
                break;
            }
        }
        for (int k = nElems; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = insertValue;
        nElems++;
    }

    public boolean delete(long deleteValue) {
        int j = find(deleteValue);
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }
}
