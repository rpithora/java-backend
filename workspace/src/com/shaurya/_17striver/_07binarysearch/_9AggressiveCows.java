package com.shaurya._17striver._07binarysearch;

import java.util.Arrays;

/**
 * Aggressive Cows : Detailed Solution
 * <p>
 * <p>
 * 137
 * <p>
 * 1
 * Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls.
 * You are also given an integer 'k' which denotes the number of aggressive cows.
 * You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
 * Find the maximum possible minimum distance.
 * <p>
 * Examples
 * Example 1:
 * Input Format:
 * N = 6, k = 4, arr[] = {0,3,4,7,10,9}
 * Result:
 * 3
 * Explanation:
 * The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.
 * <p>
 * Example 2:
 * Input Format:
 * N = 5, k = 2, arr[] = {4,2,1,3,6}
 * Result:
 * 5
 * Explanation:
 * The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions {1, 6}.
 * <p>
 * Why do we need to sort the stalls?
 * <p>
 * To arrange the cows in a consecutive manner while ensuring a certain distance between them, the initial step is to sort the stalls based on their positions. In a sorted array, the minimum distance will always be obtained from any two consecutive cows. Arranging the cows in a consecutive manner does not necessarily mean placing them in consecutive stalls.
 * <p>
 * Assume the given stalls array is: {1,2,8,4,9} and after sorting it will be {1, 2, 4, 8, 9}. The given number of cows is 3.
 */
public class _9AggressiveCows {
    public static void main(String[] args) {
        int N = 6, k = 4, arr[] = {0, 3, 4, 7, 10, 9};
        int maxDistance = find(arr, N, k);
        System.out.println(maxDistance);
    }

    private static int find(int[] arr, int n, int k) {

        Arrays.sort(arr);
        int low = 1, high = arr[n - 1] - arr[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(arr, mid, k)) {
                low = mid + 1;
            } else
                high = mid - 1;
        }

        return high;
    }

    private static boolean canWePlace(int[] arr, int dist, int cows) {
        int n = arr.length; //size of array
        int cntCows = 1; //no. of cows placed
        int last = arr[0]; //position of last placed cow.
        for (int i = 1; i < n; i++) {
            if (arr[i] - last >= dist) {
                cntCows++; //place next cow.
                last = arr[i]; //update the last location.
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }
}
