package com.rolandoasmat;

import java.util.Arrays;

public class MergeSort {

    /**
     * Recursive merge sort
     *
     * https://www.geeksforgeeks.org/merge-sort/
     */
    public void recursiveMergeSort(int[] array) {
        recursiveMergeSort(array, 0, array.length-1);
    }
    private void recursiveMergeSort(int[] array, int i, int j) {
        if (i < j) {
            int mid = (i + j)/2;
            recursiveMergeSort(array, i, mid);
            recursiveMergeSort(array, mid+1, j);
            recursiveMerge(array, i, mid, j);
        }
    }
    private void recursiveMerge(int[] array, int i, int mid, int j) {
        if (i >=0 && j <= array.length-1 && i < j) {
            int[] leftHalf = Arrays.copyOfRange(array, i, mid+1);
            int l = 0;
            int[] rightHalf = Arrays.copyOfRange(array, mid+1, j+1);
            int r = 0;

            for (int k = i; k <= j; k++) {
                if (l == leftHalf.length) {
                    array[k] = rightHalf[r];
                    r++;
                } else if (r == rightHalf.length) {
                    array[k] = leftHalf[l];
                    l++;
                } else if (leftHalf[l] < rightHalf[r]) {
                    array[k] = leftHalf[l];
                    l++;
                } else {
                    array[k] = rightHalf[r];
                    r++;
                }
            }

        }
    }
}
