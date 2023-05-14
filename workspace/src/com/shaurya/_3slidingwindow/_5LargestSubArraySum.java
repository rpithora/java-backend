package com.shaurya._3slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class _5LargestSubArraySum {
    public static void main(String[] args) {
        int arr[] = {4, 1, 1, 1, 2, 3, 5} ;
        int target = 5;
        solution(arr, target);
    }

    private static void solution(int[] arr, int target) {
        int i=0, j=0, n=arr.length, sum=0;
        List<Integer> al = new ArrayList<>();
        while (j<n){
            sum+=arr[j];
            if(sum == target){
                System.out.println("Found Sub Array : " + (j-i+1));
                al.add(j-i+1);
            }else if(sum > target){
                while (sum > target){
                    sum -= arr[i];
                    i++;
                }
                if(sum == target){
                    System.out.println("Found Sub Array : " + (j-i+1));
                    al.add(j-i+1);
                }
            }
            j++;
        }
        System.out.println(al);
        int ans = al.stream().reduce(Integer.MIN_VALUE, (a, b) -> Math.max(a, b));
        System.out.println(ans);
    }
}
