package com.shaurya._12dp;

import java.util.Arrays;

public class _22MinimumSubsetSumDifference {
    public static void main(String[] args) {
        int []wt = {3, 6, 11, 4};
        int lSum = Arrays.stream(wt).sum();
        int rSum = 0;
        int mixSubSetSumDiff = solution(wt, lSum, rSum, wt.length);
        System.out.println(mixSubSetSumDiff);
        System.out.println("::::::::::");
        //int count = solution(wt, lSum, rSum, wt.length,1);
        //System.out.println(count);
    }

    private static int solution(int[] wt, int lSum, int rSum, int n) {
        if(n == 0){
            return Math.abs(lSum-rSum);
        }
        return Math.min(solution(wt, lSum-wt[n-1], rSum+wt[n-1], n-1),
                solution(wt, lSum, rSum, n-1));
    }

    private static int solution(int[] wt, int lSum, int rSum, int n, int difference) {
        if(n == 0){
            if(difference == Math.abs(lSum-rSum))
                return 1;
            return 0;
        }
        return solution(wt, lSum-wt[n-1], rSum+wt[n-1], n-1)+
                solution(wt, lSum, rSum, n-1);
    }
}
