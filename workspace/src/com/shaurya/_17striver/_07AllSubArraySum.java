package com.shaurya._17striver;

public class _07AllSubArraySum {
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        solution(arr);
    }
    // Contribution Technique : arr[i] element will be contributed (i+1) * (n-i) Times
    private static void solution(int[] arr) {
        int totalSum = 0;
        for(int i=0; i<arr.length; i++){
            totalSum = totalSum + ((i+1) * (arr.length - i) * arr[i]);
        }
        System.out.println("Total Sum : " + totalSum);
    }
}
