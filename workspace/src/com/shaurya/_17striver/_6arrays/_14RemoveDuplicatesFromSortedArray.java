package com.shaurya._17striver._6arrays;

import java.util.Arrays;

public class _14RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(arr);
        System.out.println(i);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
