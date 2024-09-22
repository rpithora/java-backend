package com.shaurya._17striver._2basicmaths;

/**
 * Find GCD of two numbers
 * 196
 * 8
 * Problem Statement: Given two integers N1 and N2, find their greatest common divisor.
 * The Greatest Common Divisor of any two integers is the largest number that divides both integers.
 * Example 1:
 * Input:N1 = 9, N2 = 12
 * Output:3
 * Explanation:Factors of 9: 1, 3 and 9
 * Factors of 12: 1, 2, 3, 4, 6, 12
 * Common Factors: 1, 3 out of which 3 is the greatest hence it is the GCD.
 */
public class _04GCD {
    public static void main(String[] args) {
        int n1 = 9;
        int n2 = 12;

        int result = findGcd1(n1, n2);
        System.out.println(result);

        result = findGcd2(n1, n2);
        System.out.println(result);

        result = findGcd3(n1, n2);
        System.out.println(result);

    }

    //bruteForce
    private static int findGcd1(int n1, int n2) {
        int minNumber = Math.min(n1, n2);
        int gcd = 0;
        for (int i = 1; i <= minNumber; i++) {
            if (n1 % i == 0 && n2 % i == 0)
                gcd = i;
        }
        return gcd;
    }

    //bruteForce : little improvement
    private static int findGcd2(int n1, int n2) {
        int minNumber = Math.min(n1, n2);
        for (int i = minNumber; i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0)
                return i;
        }
        return -1;
    }

    /**
     * optimal solution -
     * Euclidean Algorithm: This is the most popular and efficient method for finding the GCD of two numbers.
     * The algorithm works by repeatedly subtracting the smaller number from the larger number until both numbers are
     * equal. At this point, the GCD is the common value. The algorithm can also be implemented using the
     * modulo operation, which makes it even faster.
     */

    private static int findGcd3(int a, int b) {
        if (b == 0)
            return a;

        return findGcd3(b, a % b);
    }
}
