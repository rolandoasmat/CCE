package com.rolandoasmat;

public class DivideAndConquerProblems {

    /**
     * You are given a one dimensional array that may contain both positive and negative integers,
     * find the sum of contiguous subarray of numbers which has the largest sum.
     *
     * https://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
     */
    int maxSubArraySum(int[] array) {
        return maxSubArraySum(array, 0, array.length-1);
    }
    private int maxSubArraySum(int[] array, int i, int j) {
        if (i == j) {
            return array[i];
        }
        int mid = (i + j) / 2;
        int leftSum = maxSubArraySum(array, i, mid);
        int rightSum = maxSubArraySum(array, mid+1, j);
        int midPointCrossPointSum = maxSumAcrossMidpoint(array, i, j);

        return Math.max(Math.max(leftSum, rightSum), midPointCrossPointSum);
    }
    private  int maxSumAcrossMidpoint(int[] array, int i, int j) {
        int mid = (i + j) / 2;

        int maxLeftSum = Integer.MIN_VALUE;
        int currentLeftSum = 0;
        for (int k = mid; k >= i; k--) {
            currentLeftSum += array[k];
            maxLeftSum = Math.max(maxLeftSum, currentLeftSum);
        }

        int maxRightSum = Integer.MIN_VALUE;
        int currentRightSum = 0;
        for (int k = mid+1; k <= j; k++) {
            currentRightSum += array[k];
            maxRightSum = Math.max(maxRightSum, currentRightSum);
        }
        return maxLeftSum + maxRightSum;
    }

    /**
     * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given
     * array such that the intgers in the subsequence are sorted in increasing order. For example,
     * if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10},
     * then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
     *
     * https://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
     */
    public int maxSumIncreasingSubsequence(int[] array) {
        // TODO
        return 0;
    }

}
