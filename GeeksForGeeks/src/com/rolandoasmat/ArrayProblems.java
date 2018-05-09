package com.rolandoasmat;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

public class ArrayProblems {

    /**
     * Search an element in a sorted and rotated array
     *
     * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
     */
    public int findNumInRotatedSortedArray(int[] array, int num) {
        return findNumInRotatedSortedArray(array, num, 0, array.length-1);
    }
    private int findNumInRotatedSortedArray(int[] array, int num, int start, int end) {
        if (start == end) {
            return array[start] == num ? start : -1;
        } else if (end - start == 1) {
            if (array[start] == num) {
                return start;
            } else if (array[end] == num) {
                return end;
            } else {
                return -1;
            }
        } else {
            int midIndex = (start + end) / 2;
            int midValue = array[midIndex];
            if (midValue == num) {
                return midIndex;
            } else {
                int startValue = array[start];
                int endValue = array[end];
                // Check right subarray
                if (midValue < endValue) {
                    if (midValue < num && num < endValue) {
                        return findNumInRotatedSortedArray(array, num, midIndex, end);
                    } else {
                        return findNumInRotatedSortedArray(array, num, start, midIndex);
                    }
                } else if (startValue < midValue) {
                    if (startValue < num && num < midValue) {
                        return findNumInRotatedSortedArray(array, num, start, midIndex);
                    } else {
                        return findNumInRotatedSortedArray(array, num, midIndex, end);
                    }
                } else {
                    return -1;
                }
            }
        }
    }

    /**
     * Two elements whose sum is closest to zero
     *
     * https://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
     */
    public TwoValues findTwoValuesWithSumClosestToZero(int[] array) {
        int start = 0;
        int end = array.length-1;

        Arrays.sort(array);

        TwoValues closestToZero = new TwoValues(array[start], array[end]);
        while (start < end) {
            int startValue = array[start];
            int endValue = array[end];

            TwoValues current = new TwoValues(startValue, endValue);
            int currentSum = current.sum();
            int currentAbsSum = current.absSum();

            if (currentAbsSum == 0) {
                return current;
            } else {
                // Update closest
                if (currentAbsSum < closestToZero.absSum()) {
                    closestToZero = current;
                }

                if (currentSum < 0) {
                    start++;
                } else {
                    end--;
                }

            }

        }
        return closestToZero;
    }

    static class TwoValues {
        int one;
        int two;

        public TwoValues(int one, int two) {
            this.one = one;
            this.two = two;
        }
        public int absSum() {
            return Math.abs(sum());
        }
        public int sum() {
            return one + two;
        }
    }

}
