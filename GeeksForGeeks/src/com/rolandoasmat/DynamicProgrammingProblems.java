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

}
