package com.shaurya._12dp;

import java.util.Arrays;
import java.util.Random;

public class _2KnapsackMemoization {
    public static void main(String[] args) {

        int []wt = new int[25];
        int []val = new int[25];

        Random random = new Random();
        for(int i=0; i<25; i++){
            wt[i] = random.nextInt(100);
        }

        for(int i=0; i<25; i++){
            val[i] = random.nextInt(1000);
        }

        /*int []wt = {1, 3, 4, 5};
        int []val = {8, 4, 5, 7};*/
        int W = 1000;

        int[][] dp = new int[wt.length+1][W+1];
        for (int[] i: dp){
            Arrays.fill(i, -1);
        }
        System.out.println("Weight Array : ");
        Arrays.stream(wt).forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("Value Array : ");
        Arrays.stream(wt).forEach(s -> System.out.print(s + " "));

        //Arrays.stream(dp).forEach(s -> Arrays.stream(s).forEach(s1 -> System.out.print(s1 + " ")));
        System.out.println();
        int maxProfit = solution(wt, val, W, wt.length, dp);
        Arrays.stream(dp).forEach(s -> Arrays.stream(s).forEach(s1 -> System.out.print(s1 + " ")));
        System.out.println();
        System.out.println("maxProfit : "+maxProfit);
    }

    private static int solution(int[] wt, int[] val, int W, int n, int[][] dp) {
        if(n == 0 || W == 0){
            return 0;
        }

        if(dp[n][W] != -1){
            System.out.println("here");
            return dp[n][W];
        }

        if(wt[n-1] <= W){
            return dp[n][W] = Math.max(val[n-1] + solution(wt, val, W-wt[n-1], n-1, dp),
                    solution(wt, val, W, n-1, dp));
        }else {
            return dp[n][W] = solution(wt, val, W, n-1, dp);
        }
    }
}
