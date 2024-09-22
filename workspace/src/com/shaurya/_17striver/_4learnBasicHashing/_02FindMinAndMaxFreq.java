package com.shaurya._17striver._4learnBasicHashing;

import java.util.HashMap;
import java.util.Map;

public class _02FindMinAndMaxFreq {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 2, 2, 2, 4, 5, 5, 5, 6};
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i : arr)
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);

        int minFreq = Integer.MAX_VALUE, min = 0;
        int maxFreq = Integer.MIN_VALUE, max = 0;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            if (freq < minFreq) {
                minFreq = freq;
                min = entry.getKey();
            }
            if (freq > maxFreq) {
                maxFreq = freq;
                max = entry.getKey();
            }
        }
        System.out.println("min = " + min + " min frequency = " + minFreq);
        System.out.println("max = " + max + " max frequency = " + maxFreq);
    }
}
