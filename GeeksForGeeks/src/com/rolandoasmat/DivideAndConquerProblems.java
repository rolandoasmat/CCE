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
        for (int k = mid; k <= j; k++) {
            currentRightSum += array[k];
            maxRightSum = Math.max(maxRightSum, currentRightSum);
        }

        return maxLeftSum + maxRightSum;
    }

}
