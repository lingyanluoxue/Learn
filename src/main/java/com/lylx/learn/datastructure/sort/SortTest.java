package com.lylx.learn.datastructure.sort;

public class SortTest {

    public static void main(String[] args) {
//        testSort();

//        testPartitionIt();

        testRecQuickSort();

    }

    private static void testRecQuickSort() {
        RecQuickSort sort = new RecQuickSort(100);
        sort.insert(42);
        sort.insert(89);
        sort.insert(63);
        sort.insert(12);
        sort.insert(94);
        sort.insert(27);
        sort.insert(78);
        sort.insert(3);
        sort.insert(7);
        sort.insert(36);

        sort.display();
//        sort.recQuickSort(0,sort.size()-1);
        sort.advancedRecQuickSort(0,sort.size()-1);
        sort.display();

    }

    private static void testSort() {
        Sort sort = new Sort(100);
        sort.insert(77);
        sort.insert(99);
        sort.insert(44);
        sort.insert(55);
        sort.insert(22);
        sort.insert(88);
        sort.insert(11);
        sort.insert(0);
        sort.insert(66);
        sort.insert(33);

//        sort.insert(30);
//        sort.insert(80);
//        sort.insert(20);

        sort.display();

//        sort.bubbleSort();
//        sort.selectionSort();
//        sort.insertSort();
        sort.shellSort();
        sort.display();
    }

    private static void testPartitionIt() {
        PartitionIt partitionIt = new PartitionIt(100);
        partitionIt.insert(149);
        partitionIt.insert(192);
        partitionIt.insert(47);
        partitionIt.insert(152);
        partitionIt.insert(159);
        partitionIt.insert(195);
        partitionIt.insert(61);
        partitionIt.insert(66);
        partitionIt.insert(17);
        partitionIt.insert(167);
        partitionIt.insert(118);
        partitionIt.insert(64);
        partitionIt.insert(27);
        partitionIt.insert(80);
        partitionIt.insert(30);
        partitionIt.insert(105);

        partitionIt.display();

        int partDex = partitionIt.partitionIt(0, partitionIt.size()-1, 99);
        System.out.println("partition is at index " + partDex);
        partitionIt.display();
    }
}
