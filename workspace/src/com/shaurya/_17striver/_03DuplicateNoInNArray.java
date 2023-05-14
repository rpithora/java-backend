package com.shaurya._17striver;

import java.util.Arrays;

public class _03DuplicateNoInNArray {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 2, 2} ;
        System.out.println(solution(arr));
        System.out.println(sol(arr));
    }

    private static int solution(int[] arr) {
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(arr[i] != i+1){
                return arr[i];
            }
        }
        return -1;
    }

    private static int sol(int[] arr) {
        int a[] = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            if(a[arr[i]-1] !=0){
                return arr[i];
            }
            a[arr[i]-1] = arr[i];
        }
        return -1;
    }
}
