package com.lylx.learn.datastructure.sort;

/**
 * 快速排序
 */
public class RecQuickSort {
    private long[] a;
    private int nElems;

    public RecQuickSort(int max) {
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
     * 三数据项取中划分：选择第一个、最后一个以及中间位置数据项的中指作为枢纽，并对三个数据项进行排序
     * a. 查找三个数据项的中值数据项比查找所有数据项的中值数据项快
     * b. 有效避免在数据有序或者逆序情况下，选择最大或者最小的数据项作为枢纽，避免了执行效率为 O(N^2)
     * c. 提高划分算法内部循环的执行速度：rightPtr 左移循环过程中，取消 rightPtr > leftPtr 检测，略微提高算法执行速度：三数据项取中不仅选择了枢纽，还对三个数据项进行了排序
     * d. 减少了必须要划分的数据项数目：对左端、中间以及右端数据项进行排序之后，划分过程不需要考虑再这三个数据项(划分可以从 left+1 和 right-1 开始)
     *
     * 快速排序：
     * 1. 数组或者子数组数据项 size <= 3 直接进行手动排序
     * 2. 数组或者子数组数据项 size > 3 ：
     *    a. 三数据项取获取枢纽，并对三个数据项进行排序
     *    b. 进行划分，划分过程结束返回划分点的位置
     *    c. 将数组或者子数组划分成左边一组和右边一组
     *    d. 调用自身对左边一组进行排序
     *    e. 调用自身对右边一组进行排序
     */
    public void advancedRecQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3) {
            manualSort(left, right);
//            insertSort(left, right);
        } else {
            long median = medianOf3(left, right);
            int partition = advancedPartitionIt(left, right, median);
            advancedRecQuickSort(left, partition - 1);
            advancedRecQuickSort(partition + 1, right);
        }
    }

    /**
     * 三数据项取中
     */
    private long medianOf3(int left, int right) {
        int center = (left + right) / 2;
        if (a[left] > a[center]) {
            swap(left, center);
        }
        if (a[left] > a[right]) {
            swap(left, right);
        }
        if (a[center] > a[right]) {
            swap(center, right);
        }
        // 将枢纽交换到 right-1 的位置上
        swap(center, right - 1);
        return a[right - 1];
    }

    /**
     * 插入排序
     * 对小的子数组使用插入排序最快，但是对三个或者更少的数据项的子数组手动排序更快
     */
    private void insertSort(int left, int right) {
        int in;
        for (int out = left + 1; out <= right; out++) {
            long temp = a[out];
            in = out;
            while (in > left && a[in - 1] > temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }

    /**
     * 对 size<=3 的子数组进行手动排序
     */
    private void manualSort(int left, int right) {
        int size = right - left + 1;
        // size is 1
        if (size <= 1) {
            return;
        }
        // size is 2
        if (size == 2) {
            if (a[left] > a[right]) {
                swap(left, right);
            }
            return;
        } else {
            // size is 3
            if (a[left] > a[right - 1]) {
                swap(left, right - 1);
            }
            if (a[left] > a[right]) {
                swap(left, right);
            }
            if (a[right - 1] > a[right]) {
                swap(right - 1, right);
            }
        }

    }

    /**
     * 划分算法
     * <p>
     * pivot：特定数据项，枢纽：三数据项取中
     * leftPtr：左边的指针（左边指示数组数据项的），向右移动，初始值：第一个数据项的左边一位
     * rightPtr: 右边的指针（右边指示数组数据项的），向左移动，初始值：最后一个数据项的右边一位
     * <p>
     * 停止和交换：
     * 1. leftPtr 遇到比 pivot 枢纽小的数据项，继续右移；遇到 >= pivot 的数据项，停止移动
     * 2. rightPtr 遇到比 pivot 枢纽大的数据项，继续左移；遇到 <= pivot 的数据项，停止移动
     * 3. 交换 leftPtr 和 rightPtr 数据项
     * 4. 继续移动 leftPtr 和 rightPtr，进行停止和交换操作，直到两个指针相遇 (leftPtr >= rightPtr)，划分结束
     * 5. 将枢纽从 right-1 的位置交换到划分点的位置处
     */
    private int advancedPartitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true) {
            // 使用三数据项取中，leftPtr 和 rightPtr 不会分别越过数组最左端或者右端：
            // 三个数据项已经排序，选择中值数据项作为枢纽，保证子数组最左端的数据项 <= 枢纽，保证最右端的数据项 >= 枢纽
            while (a[++leftPtr] < pivot) ;
            while (a[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        // 将枢纽从 right-1 的位置交换到划分点的位置处
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    /**
     * 针对数据项是任意排列的，选择最右端数据项作为枢纽，不会太坏
     * 针对数据是有序或者逆序时，从数组的一端或者另一端选择数据项作为枢纽都不太好：
     * a. 算法执行效率降低到 O(N^2)
     * b. 递归方法调用次数也增加了，调用次数套多，递归工作栈可能会发生溢出，从而使系统瘫痪
     *
     * 快速排序：
     * 1. 数组或者子数组数据项 size is 1 ,return
     * 2. 选择最右端数据作为枢纽，进行划分，划分过程结束返回划分点的位置
     * 3. 将数组或者子数组划分成左边一组和右边一组
     * 4. 调用自身对左边一组进行排序
     * 5. 调用自身对右边一组进行排序
     */
    public void recQuickSort(int left, int right) {
        // size is 1
        if (right - left <= 0) {
            return;
        }
        // 选择最右端数据作为枢纽，消除了不必要的检测，加速代码的执行
        int partition = partitionIt(left, right, a[right]);
        recQuickSort(left, partition - 1);
        recQuickSort(partition + 1, right);
    }

    /**
     * 划分算法
     * <p>
     * pivot：特定数据项，枢纽：选择最右端数据
     * leftPtr：左边的指针（左边指示数组数据项的），向右移动，初始值：第一个数据项的左边一位
     * rightPtr: 右边的指针（右边指示数组数据项的），向左移动，初始值：最后一个数据项的右边一位
     * <p>
     * 停止和交换：
     * 1. leftPtr 遇到比 pivot 枢纽小的数据项，继续右移；遇到 >= pivot 的数据项，停止移动
     * 2. rightPtr 遇到比 pivot 枢纽大的数据项，继续左移；遇到 <= pivot 的数据项，停止移动
     * 3. 交换 leftPtr 和 rightPtr 数据项
     * 4. 继续移动 leftPtr 和 rightPtr，进行停止和交换操作，直到两个指针相遇 (leftPtr >= rightPtr)，划分结束
     */
    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            // 选择最右端的数据作为枢纽，假设所有数据都小于枢纽，leftPtr 最终会停在枢纽这个位置，防止了 leftPtr 右移越过数组最右端
            while (a[++leftPtr] < pivot) ;
            while (rightPtr > 0 && a[--rightPtr] > pivot) ;
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
