package com.shaurya._17striver._20misc;

import java.util.Arrays;
import java.util.Stack;

public class _09NextGreaterElementII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        _09NextGreaterElementII nextGreaterElementII = new _09NextGreaterElementII();
        int[] ints = nextGreaterElementII.nextGreaterElements(arr);
        Arrays.stream(ints).forEach(s -> System.out.print(s + " "));
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int result[] = new int[n];


        for (int i = 2 * n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }

            if (i < n) {
                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(nums[i % n]);
        }
        return result;
    }
}
