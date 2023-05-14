package com.shaurya._12dp;

import java.util.Arrays;

public class _15LCSTopDown {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int length = solution(s1, s2, s1.length(), s2.length(), dp);

        for(int arr[] : dp){
            Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }

        System.out.println("LCS Length: " + length);
    }

    private static int solution(String s1, String s2, int n, int m, int dp[][]) {
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
