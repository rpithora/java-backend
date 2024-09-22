package com.shaurya._17striver._20misc;

import java.util.Arrays;

public class _02SortArrayDutchFlag {
    public static void main(String[] args) {
        int arr[] = {2, 0, 2, 1, 1, 0} ;
        solution(arr);
    }

    private static void solution(int[] arr) {
        int temp = 0, left = 0, mid = 0, right = arr.length-1;
        while (mid<=right){
            switch (arr[mid]){
                case 0:
                    temp = arr[left];
                    arr[left] = arr[mid];
                    arr[mid] = temp;
                    left++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[mid];
                    arr[mid] = arr[right];
                    arr[right] = temp;
                    right--;
                    break;
            }
        }
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }
}
