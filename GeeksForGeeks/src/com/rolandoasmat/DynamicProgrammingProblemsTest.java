package com.rolandoasmat;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class DynamicProgrammingProblemsTest {
    DynamicProgrammingProblems solver = new DynamicProgrammingProblems();

    @Test
    void containsSum() {
        HashSet<Integer> set = generateTestSet();
        int sum = 9;
        assertTrue(solver.containsSum(set, sum));

        set = generateTestSet();
        sum = 3;
        assertTrue(solver.containsSum(set, sum));

        set = generateTestSet();
        sum = 17;
        assertTrue(solver.containsSum(set, sum));

        set = generateTestSet();
        sum = 50;
        assertTrue(solver.containsSum(set, sum));

        set = generateTestSet();
        sum = 60;
        assertTrue(solver.containsSum(set, sum));
    }

    private HashSet<Integer> generateTestSet() {
        HashSet<Integer> set = new HashSet<>();
        set.add(3);
        set.add(34);
        set.add(4);
        set.add(12);
        set.add(5);
        set.add(2);

        return set;
    }
}