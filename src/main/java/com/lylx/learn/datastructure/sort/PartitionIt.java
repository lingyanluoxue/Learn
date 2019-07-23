package com.lylx.learn.datastructure.sort;

public class PartitionIt {
    private long[] a;
    private int nElems;

    public PartitionIt(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long insertValue) {
        a[nElems] = insertValue;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    public int size() {
        return nElems;
    }

    /**
     * 划分算法
     * <p>
     * pivot：特定数据项，枢纽
     * leftPtr：左边的指针（左边指示数组数据项的），向右移动，初始值：第一个数据项的左边一位
     * rightPtr: 右边的指针（右边指示数组数据项的），向左移动，初始值：最后一个数据项的右边一位
     * <p>
     * 停止和交换：
     * 1. leftPtr 遇到比 pivot 枢纽小的数据项，继续右移；遇到 >= pivot 的数据项，停止移动
     * 2. rightPtr 遇到比 pivot 枢纽大的数据项，继续左移；遇到 <= pivot 的数据项，停止移动
     * 3. 交换 leftPtr 和 rightPtr 数据项
     * 4. 继续移动 leftPtr 和 rightPtr，进行停止和交换操作，直到两个指针相遇 (leftPtr >= rightPtr)，划分结束
     */
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            // 假设所有数据都小于枢纽，leftPtr 将会遍历整个数组，甚至有可能跑出数组最右端，为避免发生数组下标越界，增加 leftPtr < right  判断
            while (leftPtr < right && a[++leftPtr] < pivot) {
                System.out.println(a[leftPtr] + "<" + pivot);
            }
            // 假设所有数据都小于枢纽，rightPtr 将会遍历整个数组，甚至有可能跑出数组最左端，为避免发生数组下标越界，增加 rightPtr > left  判断
            while (rightPtr > left && a[--rightPtr] > pivot) {
                System.out.println(a[rightPtr] + ">" + pivot);
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        return leftPtr;
    }

    private void swap(int leftPtr, int rightPtr) {
        long temp = a[leftPtr];
        a[leftPtr] = a[rightPtr];
        a[rightPtr] = temp;
    }

}
