package com.shaurya._7stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _7RainWaterTrapping {
    public static void main(String[] args) {
        int arr[] = {3,0,0,2,0,4};
        Arrays.stream(arr).forEach(s -> System.out.print(s+" "));
        System.out.println();
        _7RainWaterTrapping rainWaterTrapping = new _7RainWaterTrapping();
        System.out.println(rainWaterTrapping.solution(arr));
    }

    private int solution(int[] arr) {
        List<Integer> lm = getLeftMax(arr);
        System.out.println(lm);
        List<Integer> rm = getRightMax(arr);
        System.out.println(rm);
        List<Integer> waterTrap = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            waterTrap.add(Math.min(lm.get(i),rm.get(i)) - arr[i]);
        }
        System.out.println(waterTrap);
        return waterTrap.stream().reduce(0, (a,b) -> a+b);
    }

    private List<Integer> getLeftMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        List<Integer> ls = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
            ls.add(max);
        }
        return ls;
    }

    private List<Integer> getRightMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        List<Integer> ls = new ArrayList<>();
        for(int i=arr.length-1; i>=0; i--){
            max = Math.max(max, arr[i]);
            ls.add(max);
        }
        return ls;
    }
}
