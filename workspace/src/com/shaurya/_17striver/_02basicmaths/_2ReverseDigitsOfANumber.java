package com.shaurya._17striver._02basicmaths;

/**
 * Problem Statement: Given an integer N return the reverse of the given number.
 * Example 1:
 * Input:N = 12345
 * Output:54321
 */
public class _2ReverseDigitsOfANumber {

    public static void main(String[] args) {
        int input = 12345;
        int i = reverseR(input);
        System.out.println(i);
        int reverse = reverse(input);
        System.out.println(reverse);
    }

    private static int reverse(int input) {
        int ans = 0;
        while (input != 0) {
            int digit = input % 10;
            ans = ans * 10 + digit;
            input = input / 10;
        }
        return ans;
    }

    private static int reverseR(int input) {
        if (input < 10)
            return input;

        System.out.print(input % 10);

        return reverse(input / 10);
    }
}
