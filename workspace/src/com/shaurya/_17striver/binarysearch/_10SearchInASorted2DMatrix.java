package com.shaurya._17striver.binarysearch;

/**
 * Search in a sorted 2D matrix
 * <p>
 * 82
 * <p>
 * 0
 * Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively.
 * The elements of each row are sorted in non-decreasing order. Moreover, the first element of a row is greater than
 * the last element of the previous row (if it exists). You are given an integer ‘target’, and your task is to find if it exists
 * in the given 'mat' or not.
 * <p>
 * Examples
 * Example 1:
 * Input Format:
 * N = 3, M = 4, target = 8,
 * mat[] =
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * Result:
 * true
 * Explanation:
 * The ‘target’  = 8 exists in the 'mat' at index (1, 3).
 */
public class _10SearchInASorted2DMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 8;
        boolean found = isPresent(mat, target);
        System.out.println(found);
    }

    private static boolean isPresent(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int i = 0, j = m - 1;

        while (i < n && j >= 0) {
            if (mat[i][j] == target) {
                return true;
            } else if (mat[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
