package com.rolandoasmat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringProblemsTest {

    @Test
    void longestPalindromicSubstring() {
        String s = "abccba";
        String expected = "abccba";
        String actual = StringProblems.longestPalindromicSubstring(s);
        assertEquals(expected, actual);
    }

    @Test
    void longestSubstringWithouthRepeatingCharacters() {
        String s = "bbbbbbb";
        int expected = 1;
        int actual = StringProblems.longestSubstringWithouthRepeatingCharacters(s);
        assertEquals(expected, actual);

        s = "abcde";
        expected = 4;
        actual = StringProblems.longestSubstringWithouthRepeatingCharacters(s);
        assertEquals(expected, actual);

        s = "abcabc";
        expected = 3;
        actual = StringProblems.longestSubstringWithouthRepeatingCharacters(s);
        assertEquals(expected, actual);

        s = "aaabbbccc";
        expected = 2;
        actual = StringProblems.longestSubstringWithouthRepeatingCharacters(s);
        assertEquals(expected, actual);
    }
}