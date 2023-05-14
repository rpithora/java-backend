package com.shaurya._1array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int arr[] = {12, 35, 1, 10, 34, 1};
        int aa[] = {1 , 2, 2, 4, 4};
        System.out.println(Arrays.stream(aa).distinct().sum());
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
        mergeSort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
        quickSort(new int[]{12, 35, 1, 10, 34, 1}, 0, arr.length - 1);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
        int secondLargest = solution(arr);
        System.out.println(secondLargest);

        // O(n)  -> Without Sorting // Two time traversal
        System.out.println(solutionWithoutSorting(new int[]{12, 35, 1, 10, 34, 1}));

        // O(n) -> Single Traversal
        System.out.println(solutionInSingleTraversal(new int[]{12, 35, 1, 10, 34, 1}));
    }

    private static int solutionInSingleTraversal(int[] ints) {
        int max = ints[0], secondMax = 0;

        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > max) {
                secondMax = max;
                max = ints[i];
            } else {
                if (ints[i] > secondMax && ints[i] != max) {
                    secondMax = ints[i];
                }
            }
        }
        return secondMax;
    }

    private static int solutionWithoutSorting(int[] ints) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ints.length; i++) {
            max = Math.max(max, ints[i]);
        }
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == max) continue;
            secondMax = Math.max(secondMax, ints[i]);
        }
        return secondMax;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int leftPtr = start;
        int rightPtr = end;
        int pivot = rightPtr;

        while (leftPtr < rightPtr) {
            while (leftPtr < rightPtr && arr[leftPtr] <= pivot) {
                leftPtr++;
            }
            while (leftPtr < rightPtr && arr[rightPtr] >= pivot) {
                rightPtr--;
            }
            swap(arr, leftPtr, rightPtr);
        }
        swap(arr, leftPtr, end);
        quickSort(arr, 0, leftPtr - 1);
        quickSort(arr, leftPtr + 1, end);
    }

    private static void swap(int[] arr, int leftPtr, int rightPtr) {
        int temp = arr[leftPtr];
        arr[leftPtr] = arr[rightPtr];
        arr[rightPtr] = temp;
    }

    private static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(arr, leftArr, rightArr);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightArr.length) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    private static int solution(int arr[]) {
        return arr[arr.length - 2];
    }
}
