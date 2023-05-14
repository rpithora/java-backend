package com.shaurya._2binarysearch;

import java.util.Arrays;

/**
 * Farmer John has built a new long barn with N stalls.
 * Given an array of integers A of size N where each element of the array represents
 * the location of the stall and an integer B which represents the number of cows.
 * <p>
 * His cows don't like this barn layout and become aggressive towards each other once put into a stall.
 * To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
 * such that the minimum distance between any two of them is as large as possible. What is the
 * largest minimum distance?
 */
public class _9AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int cows = 3;
        _9AggressiveCows aggressiveCows = new _9AggressiveCows();
        System.out.println(aggressiveCows.solve(arr, cows));
    }

    public int solve(int[] arr, int cows) {
        Arrays.sort(arr);

        int n = arr.length;
        int start = 1; //min distance between 2 stalls can be 1 only
        int end = arr[n - 1] - arr[0]; //max distance between 2 stalls
        int ans = 1;

        while (start <= end) {
            int mid = (start + (end - start) / 2);

            if (check(mid, arr, cows)) {
                ans = mid;
                start = mid + 1; // going right to increase the distance
            } else
                end = mid - 1;
        }
        return ans;
    }

    public boolean check(int mid, int[] arr, int cows) {
        int n = arr.length;
        int cowsCount = 1;
        int prev = 0;

        for (int i = 1; i < n; i++) {
            if ((arr[i] - arr[prev]) >= mid) {
                cowsCount++;
                prev = i;
            }
        }

        return (cowsCount >= cows);
    }
}
