package com.shaurya._17striver.binarysearch;

/**
 * Peak element in Array
 * <p>
 * <p>
 * 107
 * <p>
 * 4
 * Problem Statement: Given an array of length N. Peak element is defined as the element greater than both of its neighbors. Formally, if 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'. Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.
 * <p>
 * Note: For the first element, the previous element should be considered as negative infinity as well as for the last element, the next element should be considered as negative infinity.
 * <p>
 * Pre-requisite: Binary Search Algorithm
 * <p>
 * Examples
 * Example 1:
 * Input Format: arr[] = {1,2,3,4,5,6,7,8,5,1}
 * Result: 7
 * Explanation: In this example, there is only 1 peak that is at index 7.
 * <p>
 * Example 2:
 * Input Format: arr[] = {1,2,1,3,5,6,4}
 * Result: 1
 * Explanation: In this example, there are 2 peak numbers that are at indices 1 and 5. We can consider any of them.
 * <p>
 * Example 3:
 * Input Format: arr[] = {1, 2, 3, 4, 5}
 * Result: 4
 * Explanation: In this example, there is only 1 peak that is at the index 4.
 * <p>
 * Example 4:
 * Input Format: arr[] = {5, 4, 3, 2, 1}
 * Result: 0
 * Explanation: In this example, there is only 1 peak that is at the index 0.
 */
public class _07PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        int peakElementIdx = findPeakElement(arr);
        System.out.println("The Peak element at the index : " + peakElementIdx + ", value : " + arr[peakElementIdx]);
    }

    private static int findPeakElement(int[] arr) {

        int n = arr.length;

        if (n == 0)
            return -1;

        if (n == 1)
            return 0;

        if (arr[n - 1] > arr[n - 2])
            return n - 1;

        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;

            if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
