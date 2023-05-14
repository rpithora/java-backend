package com.shaurya._8heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _5TopKFrequentNumber {

    public static void main(String[] args) {
        int arr[] = {1,1,1,4,3,3,3,3,2,2} ;
        int k = 2;
        solution(arr, k);
    }

    private static void solution(int[] arr, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : arr)
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);

        PriorityQueue<Map.Entry> minHeap = new PriorityQueue<>((a,b) -> (Integer)a.getValue() - (Integer)b.getValue());
        for (Map.Entry entry : hashMap.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k)
                minHeap.poll();
        }

        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll().getKey());
        }
    }
}
