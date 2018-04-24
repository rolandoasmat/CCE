package com.rolandoasmat;

public class Main {

    public static void main(String[] args) { }

    /**
     * Find the length of the longest substring without a repeating character
     *  eeeee => 1
     *  abcabc => 3
     *  abcabcde => 4
     * @param s String to check
     * @return length
     */
    public static int longestLengthOfSubstringWithouthRepeatingCharacters(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int maxCount = 0;
        int charactersSet = 0;
        for(int i = 0; i < s.length(); i++) {
            int currentChar = 1 << s.charAt(i) - 97;
            boolean contains = (charactersSet & currentChar) > 0;
            if(contains) {
                maxCount = Math.max(count, maxCount);
                if(i > 0){
                    int previousChar = 1 << s.charAt(i-1) - 97;
                    count = previousChar == currentChar ? 0 : 1;
                } else {
                    count = 0;
                }

                charactersSet = 0;
            } else {
                count++;
                charactersSet |= currentChar;
                if(i == s.length()-1 && s.length() > 1) {
                    int previousChar = 1 << s.charAt(i-1) - 97;
                    if (previousChar != currentChar)  count++ ;
                }
            }
        }
        return Math.max(count, maxCount);
    }


    /**
     * Find the longest substring of S that is also a palindrome.
     * @param s
     * @return substring
     */
    static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] matrix = new boolean[n][n];
        int maxI = 0;
        int maxJ = 0;

        // Set palindromes of size 1 and 2
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = true;
                }
                char charAtI = s.charAt(i);
                char charAtJ = s.charAt(j);
                if(charAtI == charAtJ && (j - i == 1)) {
                    matrix[i][j] = true;
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        // Set palindromes of other sizes
        for(int i = n-1; i >= 0 ; i--) {
            for(int j = 0; j < n; j++) {
                boolean valid = (i+1 < n && j-1 > 0);
                boolean smallerPalin = valid && matrix[i+1][j-1];
                if(smallerPalin && s.charAt(i) == s.charAt(j)) {
                    matrix[i][j] = true;
                    if(j - i > maxJ - maxI) {
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        return s.substring(maxI, maxJ+1);
    }
}
