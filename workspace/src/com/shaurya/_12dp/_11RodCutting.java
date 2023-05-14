package com.shaurya._12dp;

public class _11RodCutting {
    public static void main(String[] args) {
        int n = 8;
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8} ;
        int price[] = {1, 14, 8, 9, 10, 17, 17, 20};
        int maxProfit = Integer.MIN_VALUE;
        maxProfit = solution(length, length.length, price, n, maxProfit);
        System.out.println(maxProfit);

        int dp[][] = new int[length.length+1][n+1];

        maxProfit = solutionTopDownUnbounded(length, length.length, price, n, dp);
        System.out.println(maxProfit);

    }

    private static int solutionTopDownUnbounded(int[] length, int length1, int[] price, int n, int dp[][]) {
        for(int i=0 ; i<length1+1; i++){
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }
        for(int i=1; i<length1+1; i++){
            for(int j=1; j<n+1; j++){
                if(length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[length1][n];
    }


    private static int solution(int[] length, int n, int[] price, int totalLength, int maxProfit) {
        if(n == 0 || totalLength == 0){
            return 0;
        }

        if(length[n-1] <= totalLength){
            maxProfit = Math.max(price[n-1] + solution(length, n, price, totalLength-length[n-1]
            ,maxProfit), solution(length, n-1, price, totalLength, maxProfit));
        }else {
            maxProfit = solution(length, n-1, price, totalLength, maxProfit);
        }
        return maxProfit;
    }
}
