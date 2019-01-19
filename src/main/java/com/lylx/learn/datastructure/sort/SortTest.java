package com.lylx.learn.datastructure.sort;

public class SortTest {

    public static void main(String[] args) {
//        testSort();

        testPartition();
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

    private static void testPartition() {
        Sort sort = new Sort(100);
        sort.insert(149);
        sort.insert(192);
        sort.insert(47);
        sort.insert(152);
        sort.insert(159);
        sort.insert(195);
        sort.insert(61);
        sort.insert(66);
        sort.insert(17);
        sort.insert(167);
        sort.insert(118);
        sort.insert(64);
        sort.insert(27);
        sort.insert(80);
        sort.insert(30);
        sort.insert(105);

        sort.display();

        int partDex = sort.partitionIt(0, sort.size()-1, 99);
        System.out.println("partition is at index " + partDex);
        sort.display();
    }
}
