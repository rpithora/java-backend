package com.shaurya._8heap;

import java.util.PriorityQueue;

public class _3KSortedArray {

    public static void main(String[] args) {
        int arr[] = {6,5,3,2,8,10,9} ;
        int k = 3;

        solution(arr, k);
    }

    private static void solution(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<arr.length;i++){
            minHeap.offer(arr[i]);
            if(minHeap.size() > k)
                System.out.println(minHeap.poll());
        }

        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
    }
}
