package com.shaurya._17striver._5sorting;

import java.util.Arrays;

public class _02BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 15, 12, 3, 2, 6};
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
        doBubbleSort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }

    private static void doBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }
}
