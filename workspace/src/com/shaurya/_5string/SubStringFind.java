package com.shaurya._5string;

import java.util.HashMap;
import java.util.Map;

public class SubStringFind {
    public static void main(String[] args) {
        SubStringFind stringFind = new SubStringFind();
        String[] words = {"baby", "caat", "dog", "bird", "car", "ax"};
        String s = "tacbnihjsr";
        System.out.println(stringFind.match_word(words, s));
    }

    private String match_word(String[] words, String s) {
        Map<Character, Integer> hMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hMap.put(c, hMap.getOrDefault(c, 0) + 1);
        }

        for (String word : words) {
            char arr[] = word.toCharArray();
            int length = arr.length;
            int counter = 0;
            String consume = "";
            for (char c : arr) {
                if (hMap.containsKey(c) && hMap.get(c) != 0) {
                    consume += c;
                    hMap.put(c, hMap.get(c) - 1);
                    counter++;
                }
            }
            
            if (length == counter)
                return word;

            for (char c : consume.toCharArray()) {
                hMap.put(c, hMap.getOrDefault(c, 0) + 1);
            }
        }
        return "Not Found";
    }
}
