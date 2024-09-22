package com.shaurya._17striver._6arrays;

/**
 * Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.
 * <p>
 * Examples
 * Example 1:
 * Input Format:
 * arr[] = {2,2,1}
 * Result:
 * 1
 * Explanation:
 * In this array, only the element 1 appear once and so it is the answer.
 */
public class _07FindNumberAppears1AndOtherNumbersTwice {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 3, 3};

        int xor = 0;

        for (int i : arr)
            xor ^= i;

        System.out.printf("The element 1 appear once : " + xor);
    }
}
