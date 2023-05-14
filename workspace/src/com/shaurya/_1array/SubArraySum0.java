package com.shaurya._1array;

import java.util.HashSet;
import java.util.Set;

public class SubArraySum0 {
    public static void main(String[] args) {
        int nums[] = {2, -3, 2, 9, 6, -6};
        int n = nums.length;
        if (isSubArrayPresentWith0Sum(nums, n))
            System.out.println("Found, A sub-array with sum 0 in present");
        else
            System.out.println("Not found, A sub-array with sum 0 is not present");
    }

    private static boolean isSubArrayPresentWith0Sum(int[] nums, int n) {
        Set<Integer> interviewbit_Set = new HashSet<>();
        int sum = 0;
        for (int i = 0 ; i < n ; i++)
        {
            sum += nums[i];
            if (sum == 0 || interviewbit_Set.contains(sum))
                return true;
            interviewbit_Set.add(sum);
        }
        return false;
    }
}
