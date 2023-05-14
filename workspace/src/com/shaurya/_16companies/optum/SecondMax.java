package com.shaurya._16companies.optum;

import java.util.Arrays;

public class SecondMax {
    public static void main(String[] args) {
        int[] arr = {100, 89, 101, 111, 1};
        mergeSort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("Second Max : " + arr[arr.length - 2]);
        System.out.println("Second Max : " + findSecondMax(new int[]{100, 89, 101, 111, 1}));
    }

    private static int findSecondMax(int[] arr) {
        int sMAx = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                sMAx = max;
                max = arr[i];
            }else {
                if(arr[i] > sMAx){
                    sMAx = arr[i];
                }
            }
        }
        return sMAx;
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
        merge(leftArr, rightArr, arr);
    }

    private static void merge(int[] leftArr, int[] rightArr, int[] arr) {
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
}
