package com.shaurya._12dp;

public class _13LCS {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";

        int length = solution(s1, s2, s1.length(), s2.length());
        System.out.println(length);

        int[] A = {1, 2, 8, 2, 1};
        int[] B = {8, 2, 1, 4, 7};
        int maxLength = solve(A, B, A.length, B.length);
        System.out.println(maxLength);
    }

    private static int solve(int []A, int []B, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }

        if(A[n-1] == B[m-1]){
            return 1 + solve(A, B, n-1, m-1);
        }else {
            return Math.max(solve(A, B, n-1, m), solve(A, B, n, m-1));
        }
    }

    private static int solution(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + solution(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(solution(s1, s2, n, m - 1), solution(s1, s2, n - 1, m));
        }
    }
}
