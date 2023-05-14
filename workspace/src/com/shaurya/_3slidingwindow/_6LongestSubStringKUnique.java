package com.shaurya._3slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _6LongestSubStringKUnique {
    public static void main(String[] args) {
        String s = "aabacbebebe" ;
        int k = 3;
        solution(s, k);
    }

    private static void solution(String s, int k) {
        int i=0, j=0, n=s.length(), max = Integer.MIN_VALUE;
        Map<Character, Integer> hMap = new HashMap<>();

        while(j<n){
            char c = s.charAt(j);
            hMap.put(c,hMap.getOrDefault(c, 0)+1);
            if(hMap.size() == k){
                max = Math.max(max, j-i+1);
            }else if(hMap.size() > k){
                while (hMap.size() > k){
                    hMap.put(s.charAt(i), hMap.get(s.charAt(i))-1);
                    if(hMap.get(s.charAt(i)) == 0){
                        hMap.remove(s.charAt(i));
                    }
                    i++;
                }
                if(hMap.size() == k){
                    max = Math.max(max, j-i+1);
                }
            }
            j++;
        }
        System.out.println("Max : " + max);
    }
}
