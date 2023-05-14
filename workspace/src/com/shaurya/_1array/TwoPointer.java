package com.shaurya._1array;

import java.util.Arrays;

public class TwoPointer {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, -2, 6, 8, 9, 11};
        int sum = 6;
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        solution(arr, sum);
    }

    private static void solution(int[] arr, int sum) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            if (arr[low] + arr[high] == sum) {
                System.out.println("[" + arr[low] + "," + arr[high] + "]");
                high--;
                low++;
            } else if (arr[low] + arr[high] > sum) {
                high--;
            } else {
                low++;
            }
        }
    }
}
