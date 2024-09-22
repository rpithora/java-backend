package com.shaurya._17striver.binarysearch;

/**
 * Minimum in Rotated Sorted Array
 * <p>
 * <p>
 * 66
 * <p>
 * 0
 * Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. Find the minimum element in the array.
 * <p>
 * Pre-requisites: Search in Rotated Sorted Array I,  Search in Rotated Sorted Array II & Binary Search algorithm
 * <p>
 * Examples
 * Example 1:
 * Input Format:
 * arr = [4,5,6,7,0,1,2,3]
 * Result:
 * 0
 * Explanation:
 * Here, the element 0 is the minimum element in the array.
 * <p>
 * Example 2:
 * Input Format:
 * arr = [3,4,5,1,2]
 * Result:
 * 1
 * Explanation:
 * Here, the element 1 is the minimum element in the array.
 */
public class _06MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int min = Integer.MAX_VALUE;
        min = findMin(arr, min);
        System.out.println(min);
    }

    private static int findMin(int[] arr, int min) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {

            if (arr[low] <= arr[high]) {
                min = Math.min(min, arr[low]);
                break;
            }

            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[mid]) {
                if (min > arr[low]) {
                    min = arr[low];
                }
                low = mid + 1;
            } else {
                if (arr[mid] <= arr[high]) {
                    if (min > arr[mid]) {
                        min = arr[mid];
                    }
                    high = mid - 1;
                }
            }
        }

        return min;
    }
}
