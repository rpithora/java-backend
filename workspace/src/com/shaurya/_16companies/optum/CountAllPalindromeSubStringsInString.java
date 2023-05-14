package com.shaurya._16companies.optum;

public class CountAllPalindromeSubStringsInString {
    public static void main(String[] args) {
        String str = "abbaeae";
        int total = count(str);
        System.out.println("Total Count : " + total);
    }

    private static int count(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (isPalindrome(str, i, j))
                    count++;
            }
        }
        return count;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        if (i > j)
            return true;

        if (str.charAt(i) != str.charAt(j))
            return false;

        return isPalindrome(str, i + 1, j - 1);
    }
}
