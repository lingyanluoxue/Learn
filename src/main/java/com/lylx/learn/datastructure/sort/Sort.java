package com.lylx.learn.datastructure.sort;

/**
 * 排序
 */
public class Sort {
    private long[] a;
    private int nElems;

    public Sort(int max) {
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
     * 冒泡排序
     * 外层 N-1趟
     * 第out趟比较次数 N-1-out次
     */
    public void bubbleSort() {
        for (int out = nElems - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    long temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                }
            }
        }
//        for (int out = 0; out < nElems - 1; out++) {
//            for (int in = 0; in < nElems - 1 - out; in++) {
//                if (a[in] > a[in + 1]) {
//                    long temp = a[in];
//                    a[in] = a[in + 1];
//                    a[in + 1] = temp;
//                }
//            }
//        }
    }

    /**
     * 选择排序
     * 外层 N-1趟
     */
    public void selectionSort() {
        long temp;
        for (int out = 0; out < nElems - 1; out++) {
            for (int in = out + 1; in < nElems; in++) {
                if (a[in] < a[out]) {
                    temp = a[out];
                    a[out] = a[in];
                    a[in] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     * 1. 被标记的数据的左边数据是局部有序的，被标记的数据和它右边的数据都是未排过序的
     * 2. 在（局部）有序组中的适当位置插入被标记的数据
     *     a. 将被标记的数据存储在一个临时变量中
     *     b. 对比被标记数据左边有序的数据，移动比被标记的数据大的部分有序数据，腾出适当位置放置被标记的数据
     *     c. 最后一次移位空出的位置，就是被标记数据应该插入的位置
     *
     * out 标记未排序的最左端的位置的数据
     * in 从out开始，向左移动
     * while 每一趟都向右移动一个已排序的数据项，直至最后一个比被标记数据大的数据移位之后停止
     */
    public void insertSort() {
        int in;
        for (int out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] > temp) {
                a[in] = a[in - 1];
                in--;
            }
            a[in] = temp;
        }
    }

    /**
     * 希尔排序
     * Knuth间隔序列：h = 3*h+1; h = (h-1)/3   【1、4、13、40、121、364】
     */
    public void shellSort() {
        int out, inner;
        long temp;

        int h = 1;
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (out = h; out < nElems; out++) {
                inner = out;
                temp = a[out];
                while (inner > h - 1 && a[inner - h] >= temp) {
                    a[inner] = a[inner - h];
                    inner -= h;
                }
                a[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

}
