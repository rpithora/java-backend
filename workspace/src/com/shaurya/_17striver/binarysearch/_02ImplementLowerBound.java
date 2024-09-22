package com.shaurya._17striver.binarysearch;

/**
 * Example 1:
 * Input Format:
 * N = 4, arr[] = {1,2,2,3}, x = 2
 * Result:
 * 1
 * Explanation:
 * Index 1 is the smallest index such that arr[1] >= x.
 * <p>
 * Example 2:
 * Input Format:
 * N = 5, arr[] = {3,5,8,15,19}, x = 9
 * Result:
 * 3
 * Explanation:
 * Index 3 is the smallest index such that arr[3] >= x.
 */
public class _02ImplementLowerBound {
    public static void main(String[] args) {
        int N = 5, arr[] = {3, 5, 8, 15, 19}, x = 9;
        int idx = find(arr, N, x);
        System.out.println(idx);
    }

    private static int find(int[] arr, int n, int x) {
        int start = 0, end = n - 1;
        int idx = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= x) {
                end = mid - 1;
                idx = mid;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }
}
