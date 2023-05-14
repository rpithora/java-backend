package com.shaurya._12dp;

public class _18LCSShortedCommonSuperSequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB" ;
        String s2 = "GXTXAYB" ;
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int length = solution(s1, s2, s1.length(), s2.length(), dp);
        System.out.println(length);

        String scs = solutionPrint(s1, s2, s1.length(), s2.length(), dp);
        System.out.println(scs);
    }

    private static String solutionPrint(String s1, String s2, int n, int m, int[][] dp) {
        StringBuffer output = new StringBuffer();
        int i=n, j=m;
        while (i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                output.append(s1.charAt(i-1));
                i--;
                j--;
            }else {
                if(dp[i][j-1] > dp[i-1][j]){
                    output.append(s2.charAt(j-1));
                    j--;
                }else {
                    output.append(s1.charAt(i-1));
                    i--;
                }
            }
        }

        while (i > 0){
            output.append(s1.charAt(i-1));
            i--;
        }
        while (j > 0){
            output.append(s2.charAt(j-1));
            j--;
        }

        return output.reverse().toString();
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
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return n+m-dp[n][m];
    }
}
