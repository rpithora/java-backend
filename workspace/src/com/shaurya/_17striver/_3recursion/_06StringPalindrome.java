package com.shaurya._17striver._3recursion;

public class _06StringPalindrome {
    public static void main(String[] args) {
        String str = "abcdca";
        boolean palindrome = isPalindrome(str, 0, str.length() - 1);
        System.out.println(palindrome);
    }

    private static boolean isPalindrome(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return isPalindrome(str, start + 1, end - 1);
    }
}
