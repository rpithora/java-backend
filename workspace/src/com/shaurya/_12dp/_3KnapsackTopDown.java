package com.shaurya._12dp;

import java.util.Arrays;

public class _3KnapsackTopDown {
    public static void main(String[] args) {
        int []wt = {1, 3, 4, 5} ;
        int []val = {8, 4, 5, 8} ;
        int W = 7; // capacity
        int maxProfit = solution(wt, val, W, wt.length);
        System.out.println(maxProfit);
        int dp[][] = new int[wt.length+1][W+1];
        maxProfit = solutionTopDown(wt, val, W, wt.length, dp);

        for(int[] i : dp){
            Arrays.stream(i).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
        System.out.println("maxProfit : "+ maxProfit);
    }

    private static int solutionTopDown(int[] wt, int[] val, int W, int n, int dp[][]) {
        // Initialize
        for (int i=0; i<n+1; i++){
            for (int j=0; j<W+1; j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }

        for(int i=1; i<n+1; i++){
            for (int j=1; j<W+1; j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }

    private static int solution(int[] wt, int[] val, int W, int n) {
        if(n == 0 || W == 0){
            return 0;
        }

        if(wt[n-1] <= W){
            return Math.max(val[n-1] + solution(wt, val, W-wt[n-1], n-1),
                    solution(wt, val, W, n-1));
        }else {
            return solution(wt, val, W, n-1);
        }
    }
}