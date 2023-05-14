package com.shaurya._12dp;

import java.util.Arrays;

public class _14LCSMemoization {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int length = solution(s1, s2, s1.length(), s2.length(), dp);
        System.out.println(length);
    }

    private static int solution(String s1, String s2, int n, int m, int[][] dp) {
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = 1 + solution(s1, s2, n-1, m-1, dp);
        }else{
            return dp[n][m] = Math.max(solution(s1, s2, n, m-1, dp), solution(s1, s2, n-1, m, dp));
        }
    }
}
