package com.rolandoasmat;

public class StringProblems {

    public static void main(String[] args) {
        StringProblems solver = new StringProblems();
        solver.printLast10LinesTest();
    }

    /**
     * Given some text lines in one string, each line is separated by ‘\n’ character.
     * Print the last ten lines. If number of lines is less than 10, then print all lines.
     *
     * https://www.geeksforgeeks.org/print-last-10-lines-of-a-given-file/
     */
    public void printLast10Lines(String s) {
        System.out.print(getLast10Lines(s));
    }
    public void printLast10LinesTest() {
        String s = "str1\nstr2\nstr3\nstr4\nstr5\nstr6\nstr7\nstr8\nstr9" +
        "\nstr10\nstr11\nstr12\nstr13\nstr14\nstr15\nstr16\nstr17" +
        "\nstr18\nstr19\nstr20\nstr21\nstr22\nstr23\nstr24\nstr25";
        printLast10Lines(s);
        System.out.println();
        s = "str1\nstr2\nstr3\nstr4\nstr5\nstr6\nstr7";
        printLast10Lines(s);
    }
    private String getLast10Lines(String s) {
        return getLastNLines(s, 10);
    }
    private String getLastNLines(String s, int n) {
        int beginIndex = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            beginIndex = i;
            char c = s.charAt(i);
            if (c == '\n') {
                n--;
                if (n == 0) {
                    break;
                }
            }
        }
        return s.substring(beginIndex);
    }



}
