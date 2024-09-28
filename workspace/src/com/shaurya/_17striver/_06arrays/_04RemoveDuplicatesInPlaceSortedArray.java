package com.shaurya._17striver._06arrays;

/**
 * Please do not auto generate this code
 */
public class _04RemoveDuplicatesInPlaceSortedArray {

    //Please do not auto generate this code
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 3};

        int i = 0;

        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        for (int k = 0; k < i + 1; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}
