package com.shaurya._17striver._2basicmaths;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all Divisors of a given Number
 * 100
 * 2
 * Problem Statement: Given an integer N, return all divisors of N.
 * A divisor of an integer N is a positive integer that divides N without leaving a remainder. In other words,
 * if N is divisible by another integer without any remainder, then that integer is considered a divisor of N.
 * Example 1:
 * Input:N = 36
 * Output:[1, 2, 3, 4, 6, 9, 12, 18, 36]
 * Explanation: The divisors of 36 are 1, 2, 3, 4, 6, 9, 12, 18, 36.
 */
public class _06PrintAllDivisors {
    public static void main(String[] args) {
        int num = 36;
        int[] size = new int[1];
        int[] arr = printAllDivisors1(num, size);

        for (int i = 0; i < size[0]; i++)
            System.out.print(arr[i] + " ");

        List<Integer> arr1 = printAllDivisors2(num, size);
        System.out.println("\n" + arr1);

    }

    private static List<Integer> printAllDivisors2(int num, int[] size) {
        int sqrt = (int) Math.sqrt(num);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= sqrt; i++) {
            if (num % i == 0) {
                list.add(i);
                if (i != num / i)
                    list.add(num / i);
            }
        }
        return list;
    }

    private static int[] printAllDivisors1(int num, int[] size) {
        int[] arr = new int[num];
        int idx = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                arr[idx++] = i;
        }
        size[0] = idx;
        return arr;
    }
}
