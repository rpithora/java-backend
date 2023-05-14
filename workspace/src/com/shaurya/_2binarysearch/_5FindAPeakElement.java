package com.shaurya._2binarysearch;

public class _5FindAPeakElement {
    public static void main(String[] args) {
        int[] arr = {5, 17, 20, 100, 11};
        _5FindAPeakElement findAPeakElement = new _5FindAPeakElement();
        System.out.println(findAPeakElement.solve(arr));
    }

    public int solve(int[] arr) {
        int n = arr.length;
        int peakElement = findPeak(arr, 0, n - 1);
        return peakElement;
    }

    public int findPeak(int[] arr, int start, int end) {
        int mid = -1;
        while (start <= end) {
            mid = (start + (end - start) / 2);
            if ((mid == 0 || (arr[mid] >= arr[mid - 1])) &&
                    (mid == arr.length - 1 || arr[mid] >= arr[mid + 1])) {
                return arr[mid];
            }else if (mid == 0 || arr[mid] >= arr[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return arr[mid];
    }
}