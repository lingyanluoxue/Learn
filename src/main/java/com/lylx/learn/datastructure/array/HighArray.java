package com.lylx.learn.datastructure.array;

/**
 * 无序数组：查找、插入、删除
 */
public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchValue) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchValue) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            return true;
        }
    }

    public void insert(long insertValue) {
        a[nElems] = insertValue;
        nElems++;
    }

    public boolean delete(long deleteValue) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == deleteValue) {
                break;
            }
        }
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
        for (int j=0;j<nElems;j++){
            System.out.print(a[j]+" ");
        }
        System.out.println("");
    }
}
