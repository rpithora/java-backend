package com.shaurya._17striver._6arrays;

/**
 * Kadane's Algorithm : Maximum Subarray Sum in an Array
 * <p>
 * <p>
 * 603
 * <p>
 * 15
 * Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
 * has the largest sum and returns its sum and prints the subarray.
 * <p>
 * Examples
 * Example 1:
 * Input:
 * arr = [-2,1,-3,4,-1,2,1,-5,4]
 * <p>
 * Output:
 * 6
 * <p>
 * Explanation:
 * [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Examples 2:
 * Input:
 * arr = [1]
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * Array has only one element and which is giving positive sum of 1.
 */
public class _11MaximumSubArraySumKadaneAlgo {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArraySum = findMaxSubArraySum(arr);
        System.out.println(maxSubArraySum);
    }

    /**
     * Kadane's Algorithm : Maximum Subarray Sum in an Array
     * Intuition:
     * The intuition of the algorithm is not to consider the subarray as a part of the answer if its sum is less than 0. A subarray with a sum less than 0 will always reduce our answer and so this type of subarray cannot be a part of the subarray with maximum sum.
     * <p>
     * Here, we will iterate the given array with a single loop and while iterating we will add the elements in a sum variable. Now, if at any point the sum becomes less than 0, we will set the sum as 0 as we are not going to consider any subarray with a negative sum. Among all the sums calculated, we will consider the maximum one.
     * <p>
     * Thus we can solve this problem with a single loop.
     * <p>
     * Approach:
     * The steps are as follows:
     * <p>
     * We will run a loop(say i) to iterate the given array.
     * Now, while iterating we will add the elements to the sum variable and consider the maximum one.
     * If at any point the sum becomes negative we will set the sum to 0 as we are not going to consider it as a part of our answer.
     * Note: In some cases, the question might say to consider the sum of the empty subarray while solving this problem. So, in these cases, before returning the answer we will compare the maximum subarray sum calculated with 0(i.e. The sum of an empty subarray is 0). And after that, we will return the maximum one.
     * For e.g. if the given array is {-1, -4, -5}, the answer will be 0 instead of -1 in this case.
     * <p>
     * This is applicable to all the approaches discussed above.
     * <p>
     * But if this case is not explicitly mentioned we will not consider this case.
     */
    private static int findMaxSubArraySum(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0, idxStart = -1, idxEnd = -1;
        for (int i = 0; i < arr.length; i++) {

            if (sum == 0) {
                start = i;
            }

            sum += arr[i];

            if (sum > max) {
                max = sum;
                idxStart = start;
                idxEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("start : " + idxStart + ", end : " + idxEnd);
        return max;
    }
}
