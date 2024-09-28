package com.shaurya._17striver._06arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Two Sum : Check if a pair with given sum exists in Array
 * <p>
 * <p>
 * 393
 * <p>
 * 11
 * Problem Statement: Given an array of integers arr[] and an integer target.
 * <p>
 * 1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
 * <p>
 * 2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.
 * <p>
 * Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
 * Result: YES (for 1st variant)
 * [1, 3] (for 2nd variant)
 * Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for the first variant and [1, 3] for 2nd variant.
 * <p>
 * Example 2:
 * Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
 * Result: NO (for 1st variant)
 * [-1, -1] (for 2nd variant)
 * Explanation: There exist no such two numbers whose sum is equal to the target.
 */
public class _09TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 12;
        boolean ifExists = ifExists1(arr, target);
        System.out.println(ifExists);
        ifExists = ifExists2(arr, target);
        System.out.println(ifExists);
    }

    private static boolean ifExists2(int[] arr, int target) {
        Set<Integer> hSet = new HashSet<>();

        for (int i=0; i<arr.length; i++) {
            int nTarget = target - arr[i];
            if (hSet.contains(nTarget)) {
                return true;
            } else {
                hSet.add(arr[i]);
            }
        }
        return false;
    }

    private static boolean ifExists1(int[] arr, int target) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        int sum = 0;
        while (i < j) {
            sum = arr[i] + arr[j];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
