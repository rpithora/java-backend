package com.shaurya._12dp;

import java.util.Arrays;

// Find Minimum Coins
public class _12CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {2, 3, 5};
        int sum = 5;
        int[][] dp = new int[coins.length+1][sum+1];
        int minWays = solution(coins, coins.length, sum, dp);
        for(int[] i : dp){
            Arrays.stream(i).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
        System.out.println("MIN WAYS :::: " + minWays);
    }

    private static int solution(int[] coins, int n, int sum, int[][] dp) {
        for(int i=0; i<n+1;i++){
            for(int j=0; j<sum+1; j++){
                if(i==0)
                    dp[i][j] = Integer.MAX_VALUE-1;
                if(j==0)
                    dp[i][j] = 0;
            }
        }
        for(int i=1, j=1; j<sum+1; j++){
            if(j%coins[0] == 0){
                dp[i][j] = j/coins[0];
            }else {
                dp[i][j] = Integer.MAX_VALUE-1;
            }
        }

        for(int i=2; i<n+1;i++){
            for(int j=2; j<sum+1; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
