package com.shaurya._17striver._6arrays;

public class _02SecondLargest {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 10, 1};
        int sMax = secondMax(arr);
        System.out.println(sMax);
    }

    private static int secondMax(int[] arr) {
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
        }
        return secondMax;
    }
}
