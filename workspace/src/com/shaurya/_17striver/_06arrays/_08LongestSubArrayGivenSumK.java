package com.shaurya._17striver._06arrays;

import java.util.Arrays;

/**
 * Longest Subarray with given Sum K(Positives)
 * <p>
 * <p>
 * 397
 * <p>
 * 3
 * Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
 * <p>
 * Examples
 * Example 1:
 * Input Format: N = 3, k = 5, array[] = {2,3,5}
 * Result: 2
 * Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.
 * <p>
 * Example 2:
 * Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
 * Result: 3
 * Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.
 */
public class _08LongestSubArrayGivenSumK {
    public static void main(String[] args) {
        //int[] arr = {2, 3, 5, 1, 9, 10, 10};
        //int k = 10;
        int[] arr = {-1, 1, 1};
        int k = 1;


        int longestSubArrayLen = longestSubArrayKSum1(arr, k);
        System.out.println("bruteforce : " + longestSubArrayLen);
        System.out.println();
        longestSubArrayLen = longestSubArrayKSum2(arr, k);
        System.out.println("\nusing prefix sum : " + longestSubArrayLen);
        System.out.println();
        longestSubArrayLen = longestSubArrayKSum3(arr, k);
        System.out.println("\n1] without prefix sum (extra space) : " + longestSubArrayLen);
        System.out.println();
        longestSubArrayLen = longestSubArrayKSum4(arr, k);
        System.out.println("\n2] without prefix sum (extra space) : " + longestSubArrayLen);
        System.out.println();
        longestSubArrayLen = longestSubArrayKSum5(arr, k);
        System.out.println("\n2] sliding window : " + longestSubArrayLen);

    }

    private static int longestSubArrayKSum3(int[] arr, int k) {
        int rangeSum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

            }
        }

        return 0;
    }

    //O(n2)
    private static int longestSubArrayKSum2(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int[] pf = new int[arr.length];

        pf[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            pf[i] = pf[i - 1] + arr[i];
        }

        Arrays.stream(arr).forEach(s -> System.out.printf(s + " "));
        System.out.printf("\n");
        Arrays.stream(pf).forEach(s -> System.out.printf(s + " "));
        System.out.printf("\n");
        int sum;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i == 0) {
                    sum = pf[j];
                } else {
                    sum = pf[j] - pf[i - 1];
                }
                if (sum == k) {
                    System.out.printf("\n i : " + i + " : j : " + j);
                    max = Math.max(max, j - i + 1);
                }

            }
        }
        return max;
    }

    private static int longestSubArrayKSum4(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int[] pf = new int[arr.length];

        pf[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            pf[i] = pf[i - 1] + arr[i];
        }

        Arrays.stream(arr).forEach(s -> System.out.printf(s + " "));
        System.out.printf("\n");
        Arrays.stream(pf).forEach(s -> System.out.printf(s + " "));
        System.out.printf("\n");
        int sum;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i == j && pf[i] == k) {
                    System.out.printf("\n Subarray -> ( " + 0 + "," + i + ")");
                } else if (pf[j] - pf[i] == k) {
                    System.out.printf("\n Subarray -> ( " + (i + 1) + "," + j + ")");
                }
            }
        }
        return -1;
    }

    //O(n3)
    private static int longestSubArrayKSum1(int[] arr, int total) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == total)
                    max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    private static int longestSubArrayKSum5(int[] arr, int total) {
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        while (j < arr.length) {

            sum += arr[j];

            if (sum == total) {
                max = Math.max(max, j - i + 1);
                System.out.println("i : j : " + i + " , " + j);
            } else if (sum > total) {
                while (i <= j && sum > total) {
                    sum -= arr[i];
                    i++;
                }
                if (sum == total) {
                    max = Math.max(max, j - i + 1);
                    System.out.println("i : j : " + i + " , " + j);
                }
            }
            j++;

        }
        return max;
    }
}
