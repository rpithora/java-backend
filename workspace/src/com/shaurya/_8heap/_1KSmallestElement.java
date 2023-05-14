package com.shaurya._8heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1KSmallestElement {

    public static void main(String[] args) {
        int arr[] = {7,10,4,3,20,15} ;
        int k = 3;

        System.out.println(solution(arr, k));
    }

    private static int solution(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        maxHeap.offer(arr[0]);
        for(int i=0; i<arr.length;i++){
            maxHeap.offer(arr[i]);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
