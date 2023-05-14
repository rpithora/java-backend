package com.shaurya._4sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        // Select the ith element, Check if this is the smallest element,
        // If yes do nothing, else swap with the actual small element
        int arr[] = { 4, 10, 2, 5, 3} ;
        for(int i=0; i<arr.length; i++){
            int minEle = arr[i];
            int minPos = i;
            for(int j=i; j< arr.length; j++){
                if(minEle > arr[j]){
                    minEle = arr[j];
                    minPos = j;
                }
            }
            if(arr[i] != arr[minPos]){
                swap(arr, i, minPos);
            }
        }
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }

    private static void swap(int arr[], int i, int minPos) {
        //System.out.println("swap : "+ i + " " + minPos);
        int temp = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = temp;
    }
}
