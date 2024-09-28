package com.shaurya._17striver._08string;

import java.util.HashMap;
import java.util.Map;

/**
 * Check if two Strings are anagrams of each other
 * <p>
 * <p>
 * 31
 * <p>
 * 1
 * Problem Statement: Given two strings, check if two strings are anagrams of each other or not.
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input: CAT, ACT
 * Output: true
 * Explanation: Since the count of every letter of both strings are equal.
 * <p>
 * Example 2:
 * Input: RULES, LESRT
 * Output: false
 * Explanation: Since the count of U and T  is not equal in both strings.
 */
public class _03CheckIfTwoStringsAreAnagramsOfEachOther {
    public static void main(String[] args) {
        String s1 = "RULES";
        String s2 = "LESRT";

        boolean result = check(s1, s2);
        System.out.println(result);
    }

    private static boolean check(String s1, String s2) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s1.toCharArray())
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

        for (char c : s2.toCharArray()) {

            if (!frequencyMap.containsKey(c))
                return false;

            frequencyMap.put(c, frequencyMap.get(c) - 1);

            if (frequencyMap.get(c) == 0)
                frequencyMap.remove(c);
        }

        return frequencyMap.size() == 0;
    }
}
