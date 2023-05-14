package com.shaurya._3slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubstringHavingTheBString {
    public static void main(String[] args) {
        String s = "timetopractice";
        String b = "toct";
        solution(s, b);
        System.out.println();
        s = "timetotcpractice";
        b = "toct";
        solution(s, b);
        System.out.println();
        s = "abbbbbbdcdcddxdhdhbadx";
        b = "abx";
        solution(s, b);
    }

    private static void solution(String s, String b) {
        Map<Character, Integer> hMap = new HashMap<>();
        for(char c : b.toCharArray()){
            hMap.put(c, hMap.getOrDefault(c, 0)+1);
        }
        int i=0, j=0, n = s.length(), count = hMap.size(), ans = Integer.MAX_VALUE;
        while (j<n){
            char ele = s.charAt(j);
            if(hMap.containsKey(ele)){
                hMap.put(ele, hMap.get(ele)-1);
                if(hMap.get(ele) == 0){
                    count--;
                }
            }
            if(count == 0){
                while (count==0){
                    if(hMap.containsKey(s.charAt(i))){
                        if(hMap.get(s.charAt(i)) <= 0){
                            ans = Math.min(ans, j-i+1);
                        }
                        hMap.put(s.charAt(i), hMap.get(s.charAt(i))+1);
                        if(hMap.get(s.charAt(i)) == 1) {
                            count++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        //ans = Math.min(ans, j-i+1);
        System.out.println("The smallest length :: " + ans);
    }
}