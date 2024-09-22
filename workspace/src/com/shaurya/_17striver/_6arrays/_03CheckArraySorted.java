package com.shaurya._17striver._6arrays;

public class _03CheckArraySorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 10};
        boolean isSorted = isSorted(arr);
        System.out.println(isSorted);
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }
}
