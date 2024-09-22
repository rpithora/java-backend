package com.shaurya._12dp;

public class _12CoinChange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; // 11111, 1112, 113, 23 122
        int sum = 5;
        int diffWays = 0;
        diffWays = solution(arr, arr.length, sum);
        System.out.println("Different Ways : " + diffWays);

        int[][] dp = new int[arr.length+1][sum+1];
        diffWays = solutionTopDownUnbounded(arr, arr.length, sum, dp);
        System.out.println(diffWays);
    }

    private static int solutionTopDownUnbounded(int[] arr, int n, int sum, int dp[][]) {
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0){
                    dp[i][j] = 0;
                }
                if(j==0){
                    dp[i][j] = 1;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    private static int solution(int[] arr, int n, int sum) {

        if(sum==0){
            return 1;
        }
        if(n==0){
            return 0;
        }

        if(arr[n-1]<=sum){
            return solution(arr, n, sum - arr[n-1])
                    + solution(arr, n-1, sum);
        }else {
            return solution(arr, n-1, sum);
        }
    }
}
