package com.shaurya._2binarysearch;

public class _3ReverseBinarySearch {
    public static void main(String[] args) {
        int []arr = {9, 8, 7, 6, 5, 4, 3, 2, 1} ;
        System.out.println(solution(arr, 5));
    }

    private static int solution(int[] arr, int element) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = start + (end - start / 2);
            if(element == arr[mid]){
                return mid;
            }else if(element < arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return  -1;
    }
}
