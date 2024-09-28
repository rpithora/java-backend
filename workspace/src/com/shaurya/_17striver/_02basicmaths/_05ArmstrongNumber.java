package com.shaurya._17striver._02basicmaths;

/**
 * Check if a number is Armstrong Number or not
 * 117
 * 2
 * Problem Statement: Given an integer N, return true it is an Armstrong number otherwise return false.
 * An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of
 * the number of digits.
 * Example 1:
 * Input:N = 153
 * Output:True
 * Explanation: 13+53+33 = 1 + 125 + 27 = 153
 */
public class _05ArmstrongNumber {
    public static void main(String[] args) {
        int num = 153;
        int length = String.valueOf(num).length();
        boolean isArmstrong = isArmstrong(num, length);
        System.out.println(isArmstrong);
    }

    private static boolean isArmstrong(int num, int length) {
        int sum = 0;
        int number = num;
        while (num != 0) {
            int digit = num % 10;
            sum += (int) Math.pow(digit, length);
            num /= 10;
        }
        return sum == number;
    }
}
