package com.shaurya._16companies.deshaw;

public class UniqueElementInSortedArray {
    public static void main(String[] args) {
        int arr[] = {2, 2, 4, 4, 5, 7, 7};
        int result = arr[0];
        for(int i=1; i<arr.length; i++){
            result^=arr[i];
        }
        System.out.println(result);
    }
}
