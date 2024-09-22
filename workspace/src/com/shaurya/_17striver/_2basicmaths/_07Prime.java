package com.shaurya._17striver._2basicmaths;

/**
 * Check if a number is prime or not
 * 102
 * 2
 * Problem Statement: Given an integer N, check whether it is prime or not. A prime number is a number that is
 * only divisible by 1 and itself and the total number of divisors is 2.
 * Example 1:
 * Input:N = 2
 * Output:True
 * Explanation: 2 is a prime number because it has two divisors: 1 and 2 (the number itself).
 */
public class _07Prime {
    public static void main(String[] args) {
        int num = 19;
        boolean isPrime = isPrime(num);
        System.out.println(isPrime);
    }

    private static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        int cnt = 0;
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                cnt++;
                if (i != num / i)
                    cnt++;
            }
        }
        return cnt != 1;
    }
}
