package com.shaurya._11tree;

import java.util.Arrays;

public class Practice {
    static int maxPartitions(int[] A) {
        int arrLength = A.length;

        // To keep track of max
        // and min elements at every index
        int[] lMax = new int[A.length];
        int[] rMin = new int[A.length];

        lMax[0] = A[0];

        for (int i = 1; i < arrLength; i++) {
            lMax[i] = Math.max(lMax[i - 1], A[i]);
        }

        rMin[arrLength - 1] = A[arrLength - 1];

        for (int i = arrLength - 2; i >= 0; i--) {
            rMin[i] = Math.min(rMin[i + 1], A[i]);
        }

        int count = 0;

        Arrays.stream(lMax).forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(rMin).forEach(s -> System.out.print(s + " "));
        System.out.println();
        for (int i = 0; i < arrLength - 1; i++) {
            if (lMax[i] <= rMin[i + 1]) {
                count++;
            }
        }

        // Return count + 1 as the final answer
        return count + 1;
    }

    public static void main(String args[]) {
        int[] arr = {2, 4, 1, 6, 5, 9, 7};

        System.out.println(maxPartitions(arr));
    }
}
