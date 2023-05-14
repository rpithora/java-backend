package com.shaurya._7stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _8StockSpanProblem {
    private class Pair{
        private int index;
        private int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }
    public static void main(String[] args) {
        _8StockSpanProblem stockSpanProblem = new _8StockSpanProblem();
        int arr[] = {100, 80, 60, 70, 60,75,85} ;
        System.out.println(stockSpanProblem.solution(arr));
    }

    private List<Integer> solution(int[] arr) {
        Stack<Pair> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();

        for (int i=0; i<arr.length; i++){
            if(stack.isEmpty()){
                output.add(1);
            }else if(!stack.isEmpty() && stack.peek().getValue() >= arr[i]){
                output.add(i-stack.peek().getIndex());
            }else{
                while (!stack.isEmpty() && stack.peek().getValue() < arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    output.add(1);
                }else if(!stack.isEmpty() && stack.peek().getValue() >= arr[i]){
                    output.add(i-stack.peek().getIndex());
                }
            }
            Pair pair = new Pair(i,arr[i]);
            stack.add(pair);
        }
        return output;
    }
}
