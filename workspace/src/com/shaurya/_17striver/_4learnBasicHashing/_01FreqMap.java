package com.shaurya._17striver._4learnBasicHashing;

import java.util.HashMap;
import java.util.Map;

public class _01FreqMap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 2, 2, 4};
        Map<Integer, Integer> freMap = new HashMap<>();

        for (int i : arr)
            freMap.put(i, freMap.getOrDefault(i, 0) + 1);

        System.out.println(freMap);
    }
}
