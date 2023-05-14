package com.shaurya._6recursion;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int arr[] = {6, 7, 1, 3, 8, 2, 4};
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        int maxRob = solution(arr, arr.length-1, dp);
        System.out.println(maxRob);
        Arrays.stream(dp).forEach(s -> System.out.print(s + " "));
    }

    private static int solution(int[] arr, int n, int dp[]) {
        if(n <= 0)
            return 0;

        if(dp[n] != -1){
            return dp[n];
        }

        int pick = arr[n] + solution(arr, n-2, dp);
        int notPick = solution(arr, n-1, dp);

        return dp[n] =  Math.max(pick, notPick);
    }
}
