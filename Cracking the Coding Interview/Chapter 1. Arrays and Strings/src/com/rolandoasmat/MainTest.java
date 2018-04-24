package com.rolandoasmat;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void longestLengthOfSubstringWithouthRepeatingCharacters() {
    }

    @org.junit.jupiter.api.Test
    void rotate() {
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int[][] expected = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}};
        Main.rotate(input);
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input.length; j++) {
                assertEquals(input[i][j], expected[i][j]);
            }
        }
    }
}