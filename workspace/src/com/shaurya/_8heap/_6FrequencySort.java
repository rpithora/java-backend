package com.shaurya._8heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _6FrequencySort {

    public static void main(String[] args) {
        int arr[] = {1,1,1,3,2,2,4};
        solution(arr);
    }

    private static void solution(int[] arr) {
        Map<Integer,Integer> hMap = new HashMap<>();

        for (int i : arr){
            hMap.put(i,hMap.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry> minHeap = new PriorityQueue<>((a,b) -> (Integer) a.getValue() - (Integer) b.getValue());
        minHeap.addAll(hMap.entrySet());

        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll().getKey());
        }
    }
}
