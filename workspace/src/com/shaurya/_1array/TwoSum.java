package com.shaurya._1array;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {10, 5, 7, -1, 5};
        int sum = 10;
        solutionBF(arr, sum);
        solutionHashSet(arr, sum);
    }

    private static void solutionHashSet(int[] arr, int sum) {
        Set<Integer> hSet = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            int rem = sum - arr[i];
            if(rem == 0){
                System.out.println("["+arr[i]+"]");
            }
            if(hSet.contains(rem)){
                System.out.println("["+arr[i]+","+rem+"]");
            }else {
                hSet.add(arr[i]);
            }
        }
        System.out.println();
    }

    private static void solutionBF(int[] arr, int sum) {
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == sum){
                    System.out.println("["+arr[i]+","+arr[j]+"]");
                }
            }
        }
        System.out.println();
    }
}
