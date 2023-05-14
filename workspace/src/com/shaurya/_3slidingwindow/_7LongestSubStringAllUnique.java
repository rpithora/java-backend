package com.shaurya._3slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _7LongestSubStringAllUnique {
    public static void main(String[] args) {
        String s = "abcabcbb";
        solution(s);

        int[] arr = {3, 2, 3, 3, 1, 3};
        int k = 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while (map.size() == k) {
                min = Math.min(min, right - left + 1);
                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(left);
                }
                left++;
            }
        }
        System.out.println(min);
    }

    private static void solution(String s) {
        int i = 0, j = 0, n = s.length(), max = Integer.MIN_VALUE;
        Map<Character, Integer> hMap = new HashMap<>();

        while (j < n) {
            char c = s.charAt(j);
            hMap.put(c, hMap.getOrDefault(c, 0) + 1);
            if (hMap.size() == j - i + 1) {
                max = Math.max(max, j - i + 1);
            } else if (hMap.size() < j - i + 1) {
                while (hMap.size() < j - i + 1) {
                    hMap.put(s.charAt(i), hMap.get(s.charAt(i)) - 1);
                    if (hMap.get(s.charAt(i)) == 0) {
                        hMap.remove(s.charAt(i));
                    }
                    i++;
                }
                if (hMap.size() == j - i + 1) {
                    max = Math.max(max, j - i + 1);
                }
            }
            j++;
        }
        System.out.println("Max : " + max);
    }


}
