package com.shaurya._1array;

import java.util.Arrays;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 0, 1, 2};
        solution(arr, arr.length);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }

    private static void solution(int[] arr, int n) {
        int low = 0, mid =0, temp=0, high = n-1;
        while (mid <= high){
            switch (arr[mid]){
                case 0:{
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    mid++;
                    low++;
                    break;
                }
                case 1:{
                    mid++;
                    break;
                }
                case 2:{
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }
}
