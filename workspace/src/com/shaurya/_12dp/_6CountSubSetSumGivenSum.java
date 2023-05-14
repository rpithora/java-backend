package com.shaurya._12dp;

import java.util.Arrays;

public class _6CountSubSetSumGivenSum {
    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 6, 8, 10, 10} ;
        int sum = 10;
        int totalSubset = solution(arr, arr.length, sum);
        System.out.println(totalSubset);

        int dp[][] = new int[arr.length+1][sum + 1];
        totalSubset = solutionTopDown(arr, arr.length, sum, dp);
        
        for(int[] i : dp){
            Arrays.stream(i).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }

        System.out.println("TotalSubset : " + totalSubset);

    }

    private static int solutionTopDown(int[] arr, int n, int sum, int[][] dp) {
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i == 0)
                    dp[i][j] = 0;

                if(j == 0)
                    dp[i][j] = 1;
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    private static int solution(int[] arr, int n, int sum) {
        if(sum == 0){
            System.out.println("here");
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(arr[n-1] <= sum){
            return solution(arr, n-1, sum - arr[n-1])
                    + solution(arr, n-1, sum);
        }else {
            return solution(arr, n-1, sum);
        }
    }
}
