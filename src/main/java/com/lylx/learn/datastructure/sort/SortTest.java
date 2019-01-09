package com.lylx.learn.datastructure.sort;

public class SortTest {

    public static void main(String[] args) {
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
}
