package com.shaurya._13backtracking;

import java.util.ArrayList;

public class _06PrintAllSubsetForTargetSum {
    public static void main(String[] args) {
        int arr[] = {3, -4, 4};
        int target = 3;
        printSubset(arr, 0, arr.length, target, new ArrayList<>());
    }

    private static void printSubset(int[] arr, int index, int n, int target, ArrayList<Integer> op) {
        for(int i=index; i<n; i++){
            op.add(arr[i]);
           // printSubset(arr, i+1, n, );
        }
    }
}
