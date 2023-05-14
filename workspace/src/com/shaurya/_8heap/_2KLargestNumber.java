package com.shaurya._8heap;

import java.util.PriorityQueue;

public class _2KLargestNumber {

    public static void main(String[] args) {
        int arr[] = {7,10,4,3,20,15} ;
        int k = 3;

        System.out.println(solution(arr, k));
    }

    private static int solution(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(arr[0]);
        for(int i=0; i<arr.length;i++){
            minHeap.offer(arr[i]);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.peek();
    }
}
