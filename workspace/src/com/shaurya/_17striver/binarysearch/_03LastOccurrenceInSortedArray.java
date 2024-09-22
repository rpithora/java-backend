package com.shaurya._17striver.binarysearch;

/**
 * Last occurrence in a sorted array
 * <p>
 * <p>
 * 114
 * <p>
 * 25
 * Given a sorted array of N integers, write a program to find the index of the last occurrence of the target key. If the target is not found then return -1.
 * <p>
 * Note: Consider 0 based indexing
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input: N = 7, target=13, array[] = {3,4,13,13,13,20,40}
 * Output: 4
 * Explanation: As the target value is 13 , it appears for the first time at index number 2.
 * <p>
 * Example 2:
 * Input: N = 7, target=60, array[] = {3,4,13,13,13,20,40}
 * Output: -1
 * Explanation: Target value 60 is not present in the array
 */
public class _03LastOccurrenceInSortedArray {
    public static void main(String[] args) {
        int N = 7, target = 13, array[] = {3, 4, 13, 13, 13, 20, 40};
        int idx = find(array, N, target);
        System.out.println(idx);
    }

    private static int find(int[] array, int n, int target) {
        int idx = -1;
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == array[mid]) {
                idx = mid;
                start = mid + 1;
            } else if (target > array[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }
}
