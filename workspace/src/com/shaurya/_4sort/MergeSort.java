package com.shaurya._4sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        Random random = new Random();
        int array[] = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100);
        }
        Arrays.stream(array).forEach(s -> System.out.print(s + " "));
        mergeSort(array);
        System.out.println();
        Arrays.stream(array).forEach(s -> System.out.print(s + " "));
    }

    private static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int arrayLength = array.length;
        int midIndex = arrayLength / 2;
        /*int leftArray[] = new int[midIndex];
        int rightArray[] = new int[arrayLength - midIndex];

        for(int i=0; i<midIndex; i++){
            leftArray[i] = array[i];
        }

        for(int i=midIndex; i<arrayLength; i++){
            rightArray[i-midIndex] = array[i];
        }*/
        int[] leftArray = Arrays.copyOfRange(array, 0, midIndex);
        int[] rightArray = Arrays.copyOfRange(array, midIndex, arrayLength);

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(array, leftArray, rightArray);
    }

    private static void merge(int array[], int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
