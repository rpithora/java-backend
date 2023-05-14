package com.shaurya._12dp;

import java.util.Arrays;

public class _4SubSetSumProblem {
    public static void main(String[] args) {
        int []arr = {2, 3, 7, 8};
        int sum = 10;
        String ans = new String();
        boolean isExists = solution(arr, arr.length, sum, ans);
        System.out.println("isExists : " + isExists);
        Boolean [][]dp = new Boolean[arr.length+1][sum+1];
        isExists = solutionTopDown(arr, arr.length, sum, dp);

        for(Boolean[] i : dp){
            Arrays.stream(i).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }

        System.out.println("isExists : " + isExists);
    }

    private static boolean solutionTopDown(int[] arr, int n, int sum, Boolean [][]dp){
        for(int i=0; i < n+1; i++){
            for (int j=0; j < sum+1; j++){
                if(i == 0){
                    dp[i][j] = false;
                }
                if (j == 0){
                    dp[i][j] = true;
                }
            }
        }

        for (int i=1; i<n+1; i++){
            for (int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];

    }

    private static boolean solution(int[] arr, int n, int sum, String ans) {

        if(sum == 0){
            System.out.println("ans : "+ ans);
            return Boolean.TRUE;
        }
        if(n == 0){
            return Boolean.FALSE;
        }
        if(arr[n-1] <= sum){
            return solution(arr, n-1, sum-arr[n-1], ans+=arr[n-1]+" ")
                    || solution(arr, n-1, sum, ans);
        }else {
            return solution(arr, n-1, sum, ans);
        }
    }
}
