package com.rolandoasmat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayProblemsTest {

    ArrayProblems solver = new ArrayProblems();

    @Test
    void findNumInRotatedSortedArray() {
        int[] array = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int expected = 1;
        int actual = solver.findNumInRotatedSortedArray(array, 6);
        assertEquals(expected, actual);
    }
}