package com.shaurya._2binarysearch;

public class _2FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 10, 10, 18, 20};
        System.out.println();
        System.out.println(firstOccurrence(arr, 10));
        System.out.println(lastOccurrence(arr, 10));
    }

    private static int lastOccurrence(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start / 2);
            if (element == arr[mid]) {
                ans = mid;
                start = mid + 1;
            } else if (element < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int firstOccurrence(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start / 2);
            if (element == arr[mid]) {
                ans = mid;
                end = mid - 1;
            } else if (element < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
