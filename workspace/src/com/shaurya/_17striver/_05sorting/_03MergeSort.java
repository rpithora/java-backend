package com.shaurya._17striver._05sorting;

import java.util.Arrays;

public class _03MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 8, 5, 1, 4, 23};
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
        doMergeSort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    //merge sort
    private static void doMergeSort(int[] arr) {
        if (arr.length < 2)
            return;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++)
            left[i] = arr[i];

        for (int i = mid; i < arr.length; i++)
            right[i - mid] = arr[i];

        doMergeSort(left);
        doMergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
