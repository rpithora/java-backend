package com.shaurya._3slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _3CountOccurrenceAnagram {
    public static void main(String[] args) {
        String s = "foaxxorfxaofr";
        String pattern = "for";
        int k = 3;
        solution(s, pattern, k);
    }

    private static void solution(String s, String pattern, int k) {
        Map<Character, Integer> hMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            hMap.put(c, hMap.getOrDefault(c, 0) + 1);
        }

        System.out.println(hMap);
        int count = hMap.size();

        int i = 0, j = 0, n = s.length();
        int ans = 0;
        while (j < n) {
            char c = s.charAt(j);
            if (hMap.containsKey(c)) {
                hMap.put(c, hMap.get(c) - 1);
                if (hMap.get(c) == 0)
                    count--;
            }
            if (j - i + 1 < k) {
                j++;
            } else {
                if (count == 0) {
                    ans++;
                }
                if (hMap.containsKey(s.charAt(i))) {
                    hMap.put(s.charAt(i), hMap.get(s.charAt(i)) + 1);
                    if (hMap.get(s.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        System.out.println("Total Anagram : " + ans);
    }
}
