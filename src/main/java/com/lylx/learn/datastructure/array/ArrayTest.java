package com.lylx.learn.datastructure.array;

public class ArrayTest {

    public static void main(String[] args) {
//        testHighArray();
//        testOrderedArray();
        testTriangleOrderedArray();
    }

    private static void testTriangleOrderedArray() {
        int maxSize = 100;
        com.lylx.learn.datastructure.triangle.OrderedArray orderedArray = new com.lylx.learn.datastructure.triangle.OrderedArray(maxSize);
        orderedArray.insert(77);
        orderedArray.insert(99);
        orderedArray.insert(44);
        orderedArray.insert(55);
        orderedArray.insert(22);
        orderedArray.insert(88);
        orderedArray.insert(11);
        orderedArray.insert(0);
        orderedArray.insert(66);
        orderedArray.insert(33);

        orderedArray.display();

        int searchValue = 55;
        if (orderedArray.find(searchValue) != orderedArray.size()) {
            System.out.println("Found " + searchValue);
        } else {
            System.out.println("can't find " + searchValue);
        }

        orderedArray.delete(00);
        orderedArray.delete(77);

        orderedArray.display();
    }

    private static void testOrderedArray() {
        int maxSize = 100;
        OrderedArray orderedArray = new OrderedArray(maxSize);
        orderedArray.insert(77);
        orderedArray.insert(99);
        orderedArray.insert(44);
        orderedArray.insert(55);
        orderedArray.insert(22);
        orderedArray.insert(88);
        orderedArray.insert(11);
        orderedArray.insert(0);
        orderedArray.insert(66);
        orderedArray.insert(33);

        orderedArray.display();

        int searchValue = 55;
        if (orderedArray.find(searchValue) != orderedArray.size()) {
            System.out.println("Found " + searchValue);
        } else {
            System.out.println("can't find " + searchValue);
        }

        orderedArray.delete(00);
        orderedArray.delete(77);

        orderedArray.display();
    }

    private static void testHighArray() {
        int maxSize = 100;
        HighArray highArray = new HighArray(maxSize);
        highArray.insert(77);
        highArray.insert(99);
        highArray.insert(44);
        highArray.insert(55);
        highArray.insert(22);
        highArray.insert(88);
        highArray.insert(11);
        highArray.insert(00);
        highArray.insert(66);
        highArray.insert(33);

        highArray.display();

        int searchValue = 35;
        if (highArray.find(searchValue)) {
            System.out.println("Found " + searchValue);
        } else {
            System.out.println("can't find " + searchValue);
        }

        int findValue = 33;
        if (highArray.find(findValue)) {
            System.out.println("Found " + findValue);
        } else {
            System.out.println("can't find " + findValue);
        }

        highArray.delete(00);
        highArray.delete(77);

        highArray.display();
    }
}
