package com.shaurya._17striver._05sorting;

/**
 * Selection Sort Algorithm
 * 485
 * 5
 * Problem Statement: Given an array of N integers, write a program to implement the Selection sorting algorithm.
 */
public class _01SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 10, 3};
        selectionSort(arr);
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
