package com.shaurya._16companies.nutanix;

import java.util.HashMap;

public class KUniqueCharInString {
    public static void main(String[] args) {
        String str = "aabbcc";  //bcc
        int k = 2;
        solution(str, k);
        int[] input = {0,1,2,2};
        System.out.println(totalFruit(input));
    }

    private static void solution(String s, int k) {
        int i=0;
        int j=0;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> hMap = new HashMap<>();
        while (j<s.length()){
            hMap.put(s.charAt(j), hMap.getOrDefault(s.charAt(j), 0)+1);
            if(hMap.size() == k){
                max = Math.max(max,j-i+1);
            }else if(hMap.size() > k){
                while(hMap.size() > k){
                    hMap.put(s.charAt(i), hMap.getOrDefault(s.charAt(i), 0)-1);
                    if(hMap.get(s.charAt(i)) <= 0){
                        hMap.remove(s.charAt(i));
                    }
                    i++;
                }
                if(hMap.size() == k){
                    max = Math.max(max,j-i+1);
                }
            }
            j++;
        }
        System.out.println("max ::: " + max);
    }

    public static int totalFruit(int[] fruits) {
        if(fruits.length < 1){
            return fruits.length;
        }
        int i=0;
        int j=0;
        int k=2;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        while (j<fruits.length){
            hMap.put(fruits[j], hMap.getOrDefault(fruits[j], 0)+1);
            if(hMap.size() <= k){
                max = Math.max(max,j-i+1);
            }else if(hMap.size() > k){
                while(hMap.size() > k){
                    hMap.put(fruits[i], hMap.getOrDefault(fruits[i], 0)-1);
                    if(hMap.get(fruits[i]) <= 0){
                        hMap.remove(fruits[i]);
                    }
                    i++;
                }
                if(hMap.size() <= k){
                    max = Math.max(max,j-i+1);
                }
            }
            j++;
        }
        return max;
    }
}
