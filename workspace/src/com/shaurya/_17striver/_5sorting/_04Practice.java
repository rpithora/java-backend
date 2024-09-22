package com.shaurya._17striver._5sorting;

import java.util.Arrays;

public class _04Practice {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};

        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();

        qus(arr);

        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    private static void qus(int[] arr) {
        qus1(arr, 0, arr.length - 1);
    }

    private static void qus1(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int p = arr[end];
        int lIdx = start;
        int rIdx = end;

        while (lIdx < rIdx) {

            while (arr[lIdx] <= p && lIdx < rIdx) {
                lIdx++;
            }

            while (arr[rIdx] >= p && lIdx < rIdx) {
                rIdx--;
            }

            int tmp = arr[lIdx];
            arr[lIdx] = arr[rIdx];
            arr[rIdx] = tmp;
        }
        int tmp1 = arr[lIdx];
        arr[lIdx] = arr[end];
        arr[end] = tmp1;

        qus1(arr, 0, lIdx-1);
        qus1(arr, lIdx + 1, end);
    }
}
