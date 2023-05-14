package com.shaurya._3slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2FirstNegativeKWindow {
    public static void main(String[] args) {
        int arr[] = {12,-1,-7,8,-15,30,16,28};
        int k= 3;
        int result[] = new int[arr.length-k+1];
        solution(arr, k, result);
        Arrays.stream(result).forEach(s-> System.out.print(s + " "));
    }

    private static void solution(int[] arr, int k, int[] result) {
        int i=0,j=0;
        List<Integer> al = new ArrayList<>();
        while(j<arr.length){
            if(arr[j] < 0)
                al.add(arr[j]);

            if(j-i+1 < k){
                j++;
            }else {
                System.out.println("j-k+1 : " + (j-k+1));
                if(al.isEmpty()){
                    result[j-k+1] = 0;
                    System.out.println("0");
                }else {
                    result[j-k+1] = al.get(0);
                    System.out.println(al.get(0));
                    if (arr[i] == al.get(0)) {
                        al.remove(0);
                    }
                }
                i++;
                j++;
            }
        }
    }
}
