package com.shaurya._17striver._08string;

/**
 * Problem Statement: Given a string s, reverse the words of the string.
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input: s=”this is an amazing program”
 * Output: “program amazing an is this”
 * <p>
 * Example 2:
 * Input: s=”This is decent”
 * Output: “decent is This”
 */
public class _01ReverseWordsInAString {

    public static void main(String[] args) {
        String s = "this is an amazing program";
        String result = extracted(s);
        System.out.println(result);
    }

    private static String extracted(String s) {
        String[] s1 = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = s1.length - 1; i >= 0; i--)
            stringBuffer.append(s1[i]).append(" ");

        return stringBuffer.toString().trim();
    }
}
