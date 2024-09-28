package com.shaurya._17striver._06arrays;

import java.util.Arrays;

/**
 * Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array
 * without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
 * <p>
 * Examples
 * Input:
 * nums = [2,0,2,1,1,0]
 * Output
 * : [0,0,1,1,2,2]
 * <p>
 * Input:
 * nums = [2,0,1]
 * Output:
 * [0,1,2]
 * <p>
 * Input:
 * nums = [0]
 * Output:
 * [0]
 */
public class _10SortArray012DutchNationalFlagAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
        sort1(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
        int[] arr2 = {2, 0, 2, 1, 1, 0, 0, 1};
        sortDutchNationalFlag(arr2);
        Arrays.stream(arr2).forEach(s -> System.out.print(s + " "));
    }

    /**
     * Algorithm / Intuition
     * This problem is a variation of the popular Dutch National flag algorithm.
     * <p>
     * This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:
     * <p>
     * arr[0….low-1] contains 0. [Extreme left part]
     * arr[low….mid-1] contains 1.
     * arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
     * <p>
     * Approach:
     * <p>
     * Note: Here in this tutorial we will work based on the value of the mid pointer.
     * <p>
     * The steps will be the following:
     * <p>
     * First, we will run a loop that will continue until mid <= high.
     * There can be three different values of mid pointer i.e. arr[mid]
     * If arr[mid] == 0, we will swap arr[low] and arr[mid] and will increment both low and mid. Now the subarray
     * from index 0 to (low-1) only contains 0.
     * If arr[mid] == 1, we will just increment the mid pointer and then the index (mid-1) will point to 1 as it
     * should according to the rules.
     * If arr[mid] == 2, we will swap arr[mid] and arr[high] and will decrement high. Now the subarray from index
     * high+1 to (n-1) only contains 2.
     * In this step, we will do nothing to the mid-pointer as even after swapping, the subarray from mid to
     * high(after decrementing high) might be unsorted. So, we will check the value of mid again in the next iteration.
     * Finally, our array should be sorted.
     */
    private static void sortDutchNationalFlag(int[] arr) {
        int start = 0, mid = 0, end = arr.length - 1;
        while (mid <= end) {
            if (arr[mid] == 0) {
                int temp = arr[start];
                arr[start] = arr[mid];
                arr[mid] = temp;
                start++;
                mid++;
            } else if (arr[mid] == 2) {
                int temp = arr[end];
                arr[end] = arr[mid];
                arr[mid] = temp;
                end--;
            } else {
                mid++;
            }
        }
    }

    private static void sort1(int[] arr) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) cnt0++;
            if (arr[i] == 1) cnt1++;
            if (arr[i] == 2) cnt2++;
        }

        for (int i = 0; i < cnt0; i++) {
            arr[i] = 0;
        }

        for (int i = cnt0; i < cnt0 + cnt1; i++) {
            arr[i] = 1;
        }

        for (int i = cnt0 + cnt1; i < arr.length; i++) {
            arr[i] = 2;
        }
    }
}
