package com.shaurya._16companies.deshaw;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4} ;
        int buy = 1;
        int dp[][] = new int[arr.length][2];
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }
        int maxProfit = solution(0, arr, buy, dp);
        for(int[] ss : dp){
            Arrays.stream(ss).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
        System.out.println("MaxProfit ::: " + maxProfit);
    }

    private static int solution(int i, int[] prices, int buy, int dp[][]) {
        if(prices.length == i){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        if(buy == 1){
            return dp[i][buy] = Math.max(-prices[i] + solution(i+1, prices,0, dp),
                    solution(i+1, prices,1, dp));
        }else{
            return dp[i][buy] = Math.max(prices[i] + solution(i+1, prices,1, dp),
                    solution(i+1, prices,0, dp));
        }

    }
}
