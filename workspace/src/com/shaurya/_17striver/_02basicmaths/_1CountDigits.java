package com.shaurya._17striver._02basicmaths;

/**
 * Problem Statement: Given an integer N, return the number of digits in N.
 * Example 1:
 * Input:N = 12345
 * Output:5
 */
public class _1CountDigits {
    public static void main(String[] args) {
        int input = 12345;
        int count = count(input);
        System.out.println(count);
    }

    private static int count(int input) {
        if (input < 10)
            return 1;

        return 1 + count(input / 10);
    }
}
