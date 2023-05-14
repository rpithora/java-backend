package com.shaurya._8heap;

import java.util.*;

public class _7ConnectRopesMinimizeCost {

    public static void main(String[] args) {
        int arr[] = {1,5,3,2,4} ;
        solution(arr);
    }

    private static void solution(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : arr){
            minHeap.offer(i);
        }
        int minCost = 0;
        while (minHeap.size() >= 2){
            int first = minHeap.poll();
            int second = minHeap.poll();

            minCost+=first+second;
            minHeap.offer(first+second);
        }
        System.out.println(minCost);
    }
}
