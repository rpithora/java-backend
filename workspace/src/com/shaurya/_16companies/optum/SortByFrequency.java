package com.shaurya._16companies.optum;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFrequency {
    public static void main(String[] args) {
        String s = "aabrdabccdddd";
        System.out.println(sortByFrq(s));
    }

    private static String sortByFrq(String s){
        Map<Character, Integer> hMap = new HashMap<>();
        for(char c : s.toCharArray()){
            hMap.put(c, hMap.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Map.Entry> maxHeap = new PriorityQueue<>((a, b) -> (Integer) b.getValue() - (Integer) a.getValue());
        for(Map.Entry entry : hMap.entrySet()){
            maxHeap.offer(entry);
        }

        StringBuffer buffer = new StringBuffer();
        while (!maxHeap.isEmpty()){
            Map.Entry entry = maxHeap.poll();
            int frequency = (Integer) entry.getValue();
            while (frequency-- > 0){
                buffer.append(entry.getKey());
            }
        }
        return buffer.toString();
    }
}
