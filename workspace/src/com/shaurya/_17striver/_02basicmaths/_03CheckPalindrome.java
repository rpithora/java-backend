package com.shaurya._17striver._02basicmaths;

/**
 * Problem Statement: Given an integer N, return true if it is a palindrome else return false.
 * A palindrome is a number that reads the same backward as forward. For example, 121, 1331, and 4554
 * are palindromes because they remain the same when their digits are reversed.
 * Example 1:
 * Input:N = 4554
 * Output:Palindrome Number
 * Explanation: The reverse of 4554 is 4554 and therefore it is palindrome number
 * Example 2:
 * Input:N = 7789
 * Output: Not Palindrome
 * Explanation: The reverse of number 7789 is 9877 and therefore it is not palindrome
 */
public class _03CheckPalindrome {
    public static void main(String[] args) {
        int num = 7789;
        int reverse = reverse(num);
        if (num == reverse)
            System.out.println(num + " is a palindrome");
        else
            System.out.println(num + " is not a palindrome");
    }

    private static int reverse(int num) {
        int ans = 0;
        while (num != 0) {
            int digit = num % 10;
            ans = ans * 10 + digit;
            num = num / 10;
        }
        return ans;
    }
}
