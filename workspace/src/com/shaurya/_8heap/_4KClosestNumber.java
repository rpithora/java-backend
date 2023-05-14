package com.shaurya._8heap;

import java.util.PriorityQueue;

public class _4KClosestNumber {

    public static void main(String[] args) {
        _4KClosestNumber kClosestNumber = new _4KClosestNumber();
        int arr[] = {5, 6, 7, 8, 9, 7};
        int x = 7;
        int k = 3;
        kClosestNumber.solution(arr, k, x);
    }

    class Pair{
        private int value;
        private double absDiff;

        public int getValue() {
            return value;
        }

        public double getAbsDiff() {
            return absDiff;
        }

        public Pair(int value, int absDiff) {
            this.value = value;
            this.absDiff = absDiff;
        }
    }

    private void solution(int[] arr, int k, int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> (int)(b.getAbsDiff() - a.getAbsDiff()));
        for(int i=0; i<arr.length; i++){
            maxHeap.offer(new Pair(arr[i], Math.abs(arr[i]-x)));
            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        while (!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll().getValue());
        }
    }
}
