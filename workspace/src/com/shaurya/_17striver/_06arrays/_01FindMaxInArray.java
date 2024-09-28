package com.shaurya._17striver._06arrays;

public class _01FindMaxInArray {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 10, 1};
        int max = findMax1(arr);
        System.out.println("max : " + max);
        int maxEle = Integer.MIN_VALUE;
        maxEle = findMax2(arr, 0, maxEle);
        System.out.println("maxEle : " + maxEle);
    }

    private static int findMax2(int[] arr, int i, int maxEle) {
        if (i == arr.length)
            return maxEle;

        maxEle = Math.max(maxEle, arr[i]);

        return findMax2(arr, i + 1, maxEle);
    }

    private static int findMax1(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
