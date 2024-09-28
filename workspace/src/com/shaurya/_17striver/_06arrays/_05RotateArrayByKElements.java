package com.shaurya._17striver._06arrays;

import java.util.Arrays;

import static com.shaurya._17striver._06arrays._05RotateArrayByKElements.Direction.LEFT;
import static com.shaurya._17striver._06arrays._05RotateArrayByKElements.Direction.RIGHT;

/**
 * Rotate array by K elements
 * <p>
 * <p>
 * 295
 * <p>
 * 17
 * Rotate array by K elements
 * <p>
 * Problem Statement: Given an array of integers, rotating array of elements by k elements either left or right.
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input: N = 7, array[] = {1,2,3,4,5,6,7} , k=2 , right
 * Output: 6 7 1 2 3 4 5
 * Explanation: array is rotated to right by 2 position .
 * <p>
 * Example 2:
 * Input: N = 6, array[] = {3,7,8,9,10,11} , k=3 , left
 * Output: 9 10 11 3 7 8
 * Explanation: Array is rotated to right by 3 position.
 */
public class _05RotateArrayByKElements {
    enum Direction {
        LEFT,
        RIGHT;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        Arrays.stream(arr).forEach(s -> System.out.printf(s + " "));
        System.out.printf("\n");
        rotateArray(arr, 2, LEFT);
        rotateArray(arr, 2, RIGHT);
        Arrays.stream(arr).forEach(s -> System.out.printf(s + " "));
    }

    private static void rotateArray(int[] arr, int k, Direction direction) {
        int[] tempArr = new int[k];

        for (int i = 0; i < k; i++)
            tempArr[i] = arr[i];

        switch (direction) {
            case LEFT:
                rotateArray(arr, k, tempArr);
                break;
            case RIGHT:
                int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
                k = 3;
                rotate(arr1, k);
                Arrays.stream(arr1).forEach(s -> System.out.print(s + " "));
                break;
        }
    }

    public static void rotate(int[] nums, int k) {
        int[] temp = new int[k];
        int n = nums.length;

        for (int i = 0; i < k; i++)
            temp[i] = nums[n + i - k];

        for (int i = n - k - 1; i >= 0; i--)
            nums[n - i] = nums[i];

        for (int i = 0; i < k; i++)
            nums[i] = temp[i];
    }

    private static void rotateArray(int[] arr, int k, int[] tempArr) {
        int i = 0;

        while (i + k < arr.length) {
            arr[i] = arr[i + k];
            i++;
        }

        for (int j = 0; j < k; j++) {
            arr[i] = tempArr[j];
            i++;
        }
    }
}
