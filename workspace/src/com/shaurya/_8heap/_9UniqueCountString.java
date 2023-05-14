package com.shaurya._8heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _9UniqueCountString {
    public static void main(String[] args) {
        String s = "UUUBBB" ;
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int minNoDel = 0;
        Map<Character, Integer> hMap = new HashMap<>();
        for(char c : s.toCharArray()){
            hMap.put(c, hMap.getOrDefault(c,0)+1);
        }
        System.out.println(hMap);
        PriorityQueue<Map.Entry> maxHeap = new PriorityQueue<>((a,b) -> (Integer) b.getValue() - (Integer) a.getValue());
        for(Map.Entry entry : hMap.entrySet()){
            maxHeap.offer(entry);
        }
        while (!maxHeap.isEmpty()){
            Map.Entry e = maxHeap.poll();
            if (!maxHeap.isEmpty() && e.getValue() == maxHeap.peek().getValue() && (Integer) maxHeap.peek().getValue() != 0){
                minNoDel++;
                e.setValue((Integer)e.getValue()-1);
                maxHeap.offer(e);
            }
        }
        return minNoDel;
    }
}
