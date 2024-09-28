package com.shaurya._17striver._06arrays;

/**
 * Find the Majority Element that occurs more than N/2 times
 * <p>
 * <p>
 * 274
 * <p>
 * 3
 * Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.
 * <p>
 * Examples
 * Example 1:
 * Input Format
 * : N = 3, nums[] = {3,2,3}
 * Result
 * : 3
 * Explanation
 * : When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution.
 * <p>
 * Example 2:
 * Input Format:
 * N = 7, nums[] = {2,2,1,1,1,2,2}
 * <p>
 * Result
 * : 2
 * <p>
 * Explanation
 * : After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.
 * <p>
 * Example 3:
 * Input Format:
 * N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}
 * <p>
 * Result
 * : 4
 */
public class _12MajorityElementMooreVotingAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        MooreVotingAlgorithm(arr);

    }

    /**
     * Optimal Approach: Moore’s Voting Algorithm:
     * Intuition:
     * If the array contains a majority element, its occurrence must be greater than the floor(N/2).
     * Now, we can say that the count of minority elements and majority elements is equal up to a certain point
     * in the array. So when we traverse through the array we try to keep track of the count of elements and the
     * element itself for which we are tracking the count.
     * <p>
     * After traversing the whole array, we will check the element stored in the variable. If the question states
     * that the array must contain a majority element, the stored element will be that one but if the question
     * does not state so, then we need to check if the stored element is the majority element or not. If not, then
     * the array does not contain any majority element.
     * <p>
     * Approach:
     * Initialize 2 variables:
     * Count –  for tracking the count of element
     * Element – for which element we are counting
     * Traverse through the given array.
     * If Count is 0 then store the current element of the array as Element.
     * If the current element and Element are the same increase the Count by 1.
     * If they are different decrease the Count by 1.
     * The integer present in Element should be the result we are expecting
     * <p>
     * Basically, we are trying to keep track of the occurrences of the majority element and minority elements
     * dynamically. That is why, in iteration 4, the count becomes 0 as the occurrence of Element and the occurrence
     * of the other elements are the same. So, they canceled each other. This is how the process works.
     * The element with the most occurrence will remain and the rest will cancel themselves.
     * Here, we can see that 2 is the majority element. But if in this array, the last two elements were 3,
     * then the Element variable would have stored 3 instead of 2. For that, we need to check if the Element is
     * the majority element by traversing the array once more. But if the question guarantees that the given array
     * contains a majority element, then we can bet the Element will store the majority one.
     */
    private static void MooreVotingAlgorithm(int[] arr) {
        int count = 0, ele = 0;

        for (int i : arr) {
            if (count == 0)
                ele = i;

            if (i == ele) {
                count++;
            } else {
                count--;
            }
        }
        /*
            if question stats that it contains the majority element then straight away return this element.
            otherwise loop again in the array to find out the frequency of ele and verify if its majority i.e.
            ele freq > floor(N/2)
         */
        System.out.println("majority element : " + ele);
    }
}
