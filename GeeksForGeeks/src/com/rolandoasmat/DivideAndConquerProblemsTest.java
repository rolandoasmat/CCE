package com.rolandoasmat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideAndConquerProblemsTest {
    DivideAndConquerProblems solver = new DivideAndConquerProblems();

    @Test
    void maxSubArraySum() {
        int[] array = new int[] {-2, -5, 6, -2, -3, 1, 5, -6};
        int expected = 7;
        int actual = solver.maxSubArraySum(array);
        assertEquals(expected, actual);
    }
}