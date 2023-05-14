package com.shaurya._12dp;

public class _20LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s1 = "AABEBCDD" ;
        String s2 = s1;
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int lrs = solution(s1, s2, s1.length(), s2.length(), dp);
        System.out.println(lrs);
    }

    private static int solution(String s1, String s2, int n, int m, int[][] dp) {
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) && i!=j){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n][m];
    }
}
