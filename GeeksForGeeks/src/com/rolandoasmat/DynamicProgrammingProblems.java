package com.rolandoasmat;

import java.util.HashSet;
import java.util.Iterator;

public class DynamicProgrammingProblems {

    /**
     * Subset Sum Problem
     *
     * Given a set of non-negative integers, and a value sum, determine if there is
     * a subset of the given set with sum equal to given sum.
     *
     * https://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
     */
    boolean containsSum(HashSet<Integer> set, int sum) {
        if (set.contains(sum)) {
            return true;
        } else {
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                int num = iterator.next();
                if (sum - num > 0) {
                    HashSet<Integer> newSet = (HashSet<Integer>) set.clone();
                    newSet.remove(num);
                    boolean contains = containsSum(newSet, sum - num);
                    if (contains) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    boolean containsSumMemoization(int[] set, int sum) {
        // Matrix where rows are set values and columns are sums from 0...sum
        boolean[][] matrix = new boolean[set.length][sum+1];
        // Initialize 0 column
        for(int i = 0; i < set.length; i++) {
            matrix[i][0] = true;
        }
        for(int i = 0; i < set.length; i++) {
            for(int j = 1; j <= sum; j++) {
                int val = set[i];
                int currentSum = j;
                if (i > 0) {
                    // Copy above row if sum is less than current value
                    if (currentSum < val) {
                        matrix[i][j] = matrix[i-1][j];
                    } else {
                        // Look for T in above row
                        if (matrix[i-1][j]) {
                            matrix[i][j] = true;
                        } else {
                            // Go up 1 and left val number of times
                            matrix[i][j] = matrix[i-1][j-val];
                        }
                    }
                } else {
                    // on the first row
                    if (val == currentSum) {
                        matrix[i][j] = true;
                    }
                }
            }
        }
        return matrix[set.length-1][sum];
    }

}
