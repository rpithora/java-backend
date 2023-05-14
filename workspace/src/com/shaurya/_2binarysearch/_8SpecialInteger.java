package com.shaurya._2binarysearch;

/**
 * Given an array of integers A and an integer B, find and return the maximum value K such that
 * there is no sub-array in A of size K with the sum of elements greater than B.
 */
public class _8SpecialInteger {
    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        int B = 130;
        _8SpecialInteger specialInteger = new _8SpecialInteger();
        System.out.println(specialInteger.solve(A, B));
    }

    public int solve(int[] A, int B) {
        int n = A.length;
        int l = 0;
        int r = n;
        int ans = 0;
        // create a long array to avoid overflow
        long[] temp = new long[n];
        for (int i = 0; i < n; i++) {
            temp[i] = A[i];
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            //this check function will validate if sub-array of size mid is valid or not
            boolean isCorrect = check(temp, mid, B);

            if (isCorrect) {
                //if the sub-array of size mid is valid then consider it as answer and check in right side
                //if there can be more valid mid-value
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    //checking the sub-array of size k is valid or not
    // condition k <= B
    boolean check(long[] A, int k, int B) {
        int n = A.length;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + A[i];
        }
        if (sum > B) {
            return false;
        }
        int l = 0, r = k - 1;
        while (r < n - 1) {
            sum = sum + A[r + 1] - A[l];
            if (sum > B) {
                return false;
            }
            l++;
            r++;
        }
        return true;
    }
}
