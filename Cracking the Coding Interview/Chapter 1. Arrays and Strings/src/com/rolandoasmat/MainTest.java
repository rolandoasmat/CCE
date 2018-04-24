package com.rolandoasmat;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void longestLengthOfSubstringWithouthRepeatingCharacters() {
        String s = "bbbbbbb";
        int expected = 1;
        int actual = Main.longestLengthOfSubstringWithouthRepeatingCharacters(s);
        assertEquals(expected, actual);

        s = "abcde";
        expected = 4;
        actual = Main.longestLengthOfSubstringWithouthRepeatingCharacters(s);
        assertEquals(expected, actual);

        s = "abcabc";
        expected = 3;
        actual = Main.longestLengthOfSubstringWithouthRepeatingCharacters(s);
        assertEquals(expected, actual);

        s = "aaabbbccc";
        expected = 2;
        actual = Main.longestLengthOfSubstringWithouthRepeatingCharacters(s);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void longestPalindrome() {
        String s = "abccba";
        String expected = "abccba";
        String actual = Main.longestPalindrome(s);
        assertEquals(expected, actual);
    }
}