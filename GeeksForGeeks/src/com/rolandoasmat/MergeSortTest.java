package com.rolandoasmat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    MergeSort solver = new MergeSort();

    @Test
    void recursiveMergeSort() {
        int[] array = {12, 11, 13, 5, 6, 7};
        solver.recursiveMergeSort(array);
        int[] expected = {5, 6, 7, 11, 12, 13};
        for(int i = 0; i < array.length; i++) {
            assertEquals(expected[i], array[i]);
        }

    }
}