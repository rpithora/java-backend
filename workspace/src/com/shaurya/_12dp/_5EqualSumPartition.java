package com.shaurya._12dp;

import java.util.Arrays;

public class _5EqualSumPartition {
    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5};
        int totalSum = Arrays.stream(arr).sum();
        System.out.println("Total Sum : "+totalSum);
        if(totalSum%2 != 0){
            System.out.println("False");
        }else{
            Boolean isExists = solution(arr, arr.length, totalSum/2);
            System.out.println("isExists : " + isExists);
            Boolean dp[][] = new Boolean[arr.length+1][totalSum/2 + 1];
            isExists = solutionTopDown(arr, arr.length, totalSum/2, dp);

            for(Boolean[] i : dp){
                Arrays.stream(i).forEach(s -> System.out.print(s + " "));
                System.out.println();
            }

            System.out.println("isExists : " + isExists);
        }
    }

    private static Boolean solutionTopDown(int[] arr, int n, int sum, Boolean dp[][]) {
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i == 0)
                    dp[i][j] = Boolean.FALSE;

                if(j == 0)
                    dp[i][j] = Boolean.TRUE;
            }
        }

        for (int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    private static Boolean solution(int[] arr, int n, int sum) {
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }

        if(arr[n-1] <= sum){
            return solution(arr, n-1, sum-arr[n-1])
                    || solution(arr, n-1, sum);
        }else {
            return solution(arr, n-1, sum);
        }
    }
}
