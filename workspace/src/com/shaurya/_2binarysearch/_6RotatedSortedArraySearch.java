package com.shaurya._2binarysearch;

/**
 * Given a sorted array of integers A of size N and an integer B.
 * <p>
 * array A is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
 * <p>
 * You are given a target value B to search. If found in the array, return its index otherwise, return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * NOTE: Users are expected to solve this in O(log(N)) time.
 */

public class _6RotatedSortedArraySearch {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int target = 1;
        _6RotatedSortedArraySearch arraySearch = new _6RotatedSortedArraySearch();
        System.out.println(arraySearch.search(arr, target));
    }

    public int search(final int[] arr, int target) {
        int mid, start = 0, end = arr.length-1;
        while (start <= end){
            mid = start + (end - start /2 );
            if(arr[mid] == target){
                return mid;
            }else if(arr[start]<= arr[mid]){
                if(target >= arr[start] && target < arr[mid]){
                    end = mid -1;
                }else {
                    start = mid + 1;
                }
            }else{
                if(target > arr[mid] && target <= arr[end]){
                    start = mid + 1;
                }else{
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}
