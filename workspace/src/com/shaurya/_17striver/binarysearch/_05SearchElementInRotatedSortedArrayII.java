package com.shaurya._17striver.binarysearch;

/**
 * Search Element in Rotated Sorted Array II
 * <p>
 * <p>
 * 77
 * <p>
 * 0
 * Problem Statement: Given an integer array arr of size N, sorted in ascending order (may contain duplicate values) and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False.
 * <p>
 * Pre-requisite: Search Element in Rotated Sorted Array I & Binary Search algorithm
 * <p>
 * Examples
 * Example 1:
 * Input Format:
 * arr = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3
 * Result:
 * True
 * Explanation:
 * The element 3 is present in the array. So, the answer is True.
 * <p>
 * Example 2:
 * Input Format:
 * arr = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 10
 * Result:
 * False
 * Explanation:
 * The element 10 is not present in the array. So, the answer is False.
 */
public class _05SearchElementInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 3, 3, 3};
        int k = 1;
        int idx = find(arr, k);
        System.out.println(idx);
    }

    private static int find(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (target == arr[mid])
                return mid;

            //Edge case
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
