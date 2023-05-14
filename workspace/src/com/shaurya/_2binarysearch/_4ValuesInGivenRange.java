package com.shaurya._2binarysearch;

import java.util.Arrays;

public class _4ValuesInGivenRange {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 2, 4};
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        int start = 1, end = 4;
        System.out.println();
        System.out.println("COUNT :" + count_the_elements(arr, n, start, end));
    }

    private static int count_the_elements(int[] arr, int n, int r1, int r2) {
        int count = 0;
        count = higherIndex(arr, n, r2) - lowerIndex(arr, n, r1) + 1;
        return count;
    }

    private static int lowerIndex(int[] arr, int n, int value) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int higherIndex(int[] arr, int n, int value) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
