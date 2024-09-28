package com.shaurya._17striver._07binarysearch;

/**
 * Search Element in a Rotated Sorted Array
 * <p>
 * <p>
 * 153
 * <p>
 * 3
 * Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k. Now the array is rotated at some pivot point unknown to you. Find the index at which k is present and if k is not present return -1.
 * <p>
 * Examples
 * Example 1:
 * Input Format: arr = [4,5,6,7,0,1,2,3], k = 0
 * Result: 4
 * Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.
 * <p>
 * Example 2:
 * Input Format: arr = [4,5,6,7,0,1,2], k = 3
 * Result: -1
 * Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.
 */
public class _04SearchElementInARotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int k = 0;
        int idx = find(arr, k);
        System.out.println(idx);

    }

    private static int find(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (k == arr[mid])
                return mid;

            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= k && k <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
