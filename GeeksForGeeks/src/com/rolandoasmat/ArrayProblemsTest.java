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

    @Test
    void findTwoValuesWithSumClosestToZero() {
        int[] array = {1, 60, -10, 70, -80, 85};
        ArrayProblems.TwoValues expected = new ArrayProblems.TwoValues(-80, 85);
        ArrayProblems.TwoValues actual = solver.findTwoValuesWithSumClosestToZero(array);
        assertEquals(expected.one, actual.one);
        assertEquals(expected.two, actual.two);
    }
}