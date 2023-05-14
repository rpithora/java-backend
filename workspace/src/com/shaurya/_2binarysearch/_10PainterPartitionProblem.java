package com.shaurya._2binarysearch;

/**
 * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length
 * of ith board.
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each
 * of them takes B units of time to paint 1 unit of the board.
 * <p>
 * Calculate and return the minimum time required to paint all boards under the constraints that
 * any painter will only paint contiguous sections of the board.
 * NOTE:
 * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially
 * by one painter, and partially by another.
 * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints
 * boards 1 and 3 but not 2 is invalid.
 * <p>
 * Return the ans % 10000003.
 */
public class _10PainterPartitionProblem {
    public static void main(String[] args) {
        int A = 10;
        int B = 1;
        int[] C = {1, 8, 11, 3};
        _10PainterPartitionProblem partitionProblem = new _10PainterPartitionProblem();
        System.out.println(partitionProblem.paint(A, B, C));
    }

    public int paint(int P, int T, int[] A) {
        int mod = 10000003;
        long sum = 0;
        long max = Integer.MIN_VALUE;
        for (int n : A) {
            sum += n;
            max = Math.max(max, n);
        }

        //range of time
        long l = max;
        long r = sum;
        long ans = 0;

        while (l <= r) {
            long mid = (l + (r - l) / 2);
            if (check(mid, P, A)) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return (int) ((ans * T) % mod);
    }

    //counting number of painters required to paint all board in mid time
    public boolean check(long mid, int P, int[] A) {
        long timeLeft = mid;
        long count = 1;

        for (int i = 0; i < A.length; i++) {
            long timeTaken = A[i];
            if (timeTaken > mid)
                return false;
            if (timeTaken <= timeLeft) {
                timeLeft -= timeTaken;
            } else {
                count++;
                timeLeft = mid - timeTaken;
            }
        }
        return (count <= P);
    }
}
