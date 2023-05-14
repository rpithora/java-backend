package com.shaurya._12dp;

public class _1Knapsack {
    public static void main(String[] args) {
        int []wt = {1, 3, 4, 5} ;
        int []val = {8, 4, 5, 7} ;
        int W = 7; // capacity
        int maxProfit = solution(wt, val, W, wt.length);
        System.out.println(maxProfit);
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
