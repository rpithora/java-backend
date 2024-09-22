package com.shaurya._17striver._20misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _01TwoSum {
    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15} ;
        int target = 9;
        Arrays.stream(solution(arr, target)).forEach(s -> System.out.print(s + " "));
    }

    private static int[] solution(int[] arr, int target) {
        Map<Integer, Integer> hMap = new HashMap<>();
        int ans[] = {-1, -1};
        for(int i=0; i<arr.length; i++){
            int reminder = target - arr[i];
            if(hMap.containsKey(reminder)){
                ans[0] = hMap.get(reminder);
                ans[1] = i;
                return ans;
            }
            hMap.put(arr[i], i);
        }
        return ans;
    }
}
