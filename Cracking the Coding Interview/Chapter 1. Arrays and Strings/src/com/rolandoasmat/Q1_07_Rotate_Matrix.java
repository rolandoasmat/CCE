package com.rolandoasmat;

/**
 * Rotate Matrix:
 *
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 */
public class Q1_07_Rotate_Matrix {

    static void rotate(int[][]matrix) {
        if(matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int N = matrix.length;
        for(int level = 0; level < N / 2; level++) {
            int levelOffset = N - level - 1;
            for(int i = level; i < N - level - 1; i++) {
                int iOffset = N - i - 1;
                int tmp = matrix[i][levelOffset];
                // Top -> right
                matrix[i][levelOffset] = matrix[level][i];
                // Left -> top
                matrix[level][i] = matrix[iOffset][level];
                // Bottom -> left
                matrix[iOffset][level] = matrix[levelOffset][iOffset];
                //Right -> bottom
                matrix[levelOffset][iOffset] = tmp;
            }
        }
    }
}
