package com.shaurya._3slidingwindow;

import java.util.PriorityQueue;

public class _4MaximumElementEachWindow {
    public static void main(String[] args) {
        int arr[] = {1 , 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        solution(arr, k);
    }

    private static void solution(int[] arr, int k) {
        int i=0, j=0, n=arr.length;
        PriorityQueue<Integer> maxQueue = new PriorityQueue((a, b) -> (Integer)b-(Integer)a);
        while (j < n){
            maxQueue.add(arr[j]);
            if(j-i+1 < k){
                j++;
            }else{
                System.out.println("Max in current window : " + maxQueue.peek());
                maxQueue.remove(arr[i]);
                i++;
                j++;
            }
        }
    }
}
