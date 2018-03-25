package com.rolandoasmat;

public class Main {

    public static void main(String[] args) {
	    String s = "bbbbb";
	    int longestLength = longestLengthOfSubstringWithouthRepeatingCharacters(s);
        print("Longest length of "+s+" is: "+longestLength);
    }

    public static <T> void print(T t) {
        System.out.println(t);
    }

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
                count = 0;
                charactersSet = 0;
            } else {
                count++;
                charactersSet |= currentChar;
            }
        }
        return Math.max(count, maxCount);
    }
}
