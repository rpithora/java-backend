package com.shaurya._7stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _6MaxAreaHistogram {
    private class Pair{
        private int index;
        private int value;

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        _6MaxAreaHistogram histogram = new _6MaxAreaHistogram();
        int arr[] = {6, 2, 5, 4, 5, 1, 6} ;
        int maxAreaHistogram = histogram.solution(arr);
        System.out.println(maxAreaHistogram);
    }

    private int solution(int[] arr) {
        List nsr = getNSR(arr);
        System.out.println(nsr);
        List nsl = getNSL(arr);
        System.out.println(nsl);

        List<Integer> width = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            width.add(((Integer)nsr.get(i) - (Integer)nsl.get(i) - 1)*arr[i]);
        }
        System.out.println(width);
        return width.stream().reduce(Integer.MIN_VALUE, (a, b) -> Math.max(a, b));
    }

    private List<Integer> getNSL(int[] arr) {
        List<Integer> op = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty()){
                op.add(-1);
            }else if(!stack.isEmpty() && stack.peek().getValue() < arr[i]){
                op.add(stack.peek().getIndex());
            }else {
                while (!stack.isEmpty() && stack.peek().getValue() > arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    op.add(-1);
                }else if(!stack.isEmpty() && stack.peek().getValue() < arr[i]){
                    op.add(stack.peek().getIndex());
                }
            }
            stack.push(new Pair(i, arr[i]));
        }
        return op;
    }

    private List<Integer> getNSR(int[] arr) {
        {
            List<Integer> op = new ArrayList<>();
            Stack<Pair> stack = new Stack<>();
            for(int i=arr.length-1; i>=0; i--){
                if(stack.isEmpty()){
                    op.add(arr.length);
                }else if(!stack.isEmpty() && stack.peek().getValue() < arr[i]){
                    op.add(stack.peek().getIndex());
                }else {
                    while (!stack.isEmpty() && stack.peek().getValue() > arr[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        op.add(arr.length);
                    }else if(!stack.isEmpty() && stack.peek().getValue() < arr[i]){
                        op.add(stack.peek().getIndex());
                    }
                }
                stack.push(new Pair(i, arr[i]));
            }
            Collections.reverse(op);
            return op;
        }
    }
}
