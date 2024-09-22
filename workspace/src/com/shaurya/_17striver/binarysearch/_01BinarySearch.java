package com.shaurya._17striver.binarysearch;

public class _01BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;

        boolean found = search(arr, target);
        System.out.println(found);
    }

    private static boolean search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int i = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
