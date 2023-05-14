package com.shaurya._13backtracking;

import java.util.ArrayList;
import java.util.List;

public class _02CountSubsetGivenSum {
    public static void main(String[] args) {
        int arr[] = {5, -2, 9} ;
        int sum = 7;
        List<Integer> ans = new ArrayList<>();
        System.out.println(solution(0, arr.length, sum, arr, 0, ans));
        ans.forEach(s -> System.out.print(s + " "));
    }

    private static int solution(int i, int n, int targetSum, int arr[], int sum, List<Integer> ans) {
        if(i == n){
            if(sum == targetSum){
                System.out.println("Counter");
                ans.forEach(s -> System.out.print(s + " "));
                System.out.println("Above the subset");
                return 1;
            }else {
                return 0;
            }
        }
        int total = 0;
        sum += arr[i];
        ans.add(arr[i]);
        total += solution(i+1, n, targetSum, arr, sum, ans);
        sum -= arr[i];
        ans.remove(Integer.valueOf(arr[i]));
        total += solution(i+1, n, targetSum, arr, sum, ans);

        return total;
    }
}
