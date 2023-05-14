package com.shreya;

import java.util.*;

class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int arr[] = {0,0};
        System.out.println(test.largestRectangleArea(arr));
    }
    class Element{
        int index;
        int value;

        public Element(int index, int value){
            this.index = index;
            this.value = value;
        }

        public int getIndex(){
            return index;
        }

        public int getValue(){
            return value;
        }
    }
    public int largestRectangleArea(int[] heights) {
        List<Integer> nsr = nsr(heights);
        nsr.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        List<Integer> nsl = nsl(heights);
        nsl.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        int[] width = new int[heights.length];
        for(int i=0; i<heights.length; i++){
            width[i] = (nsr.get(i) - nsl.get(i) -1) * heights[i];
        }
        Arrays.stream(width).forEach(s -> System.out.print(s + " "));
        int max = Integer.MIN_VALUE;
        for(int i=0; i<width.length; i++){
            max = Math.max(max,width[i]);
        }
        System.out.println();
        return max;
    }
    private List<Integer> nsr(int[] heights){
        Stack<Element> stack = new Stack<>();
        List<Integer> op = new ArrayList<>();
        for(int i=heights.length-1; i>=0 ;i--){
            if(stack.isEmpty()){
                op.add(heights.length);
            }else if(!stack.isEmpty() && stack.peek().getValue()<heights[i]){
                op.add(stack.peek().getIndex());
            }else{
                while(!stack.isEmpty() && stack.peek().getValue()>heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    op.add(heights.length);
                }else if(!stack.isEmpty() && stack.peek().getValue()<heights[i]){
                    op.add(stack.peek().getIndex());
                }
            }
            Element e = new Element(i, heights[i]);
            stack.push(e);
        }
        Collections.reverse(op);
        return op;
    }
    private List<Integer> nsl(int[] heights){
        Stack<Element> stack = new Stack<>();
        List<Integer> op = new ArrayList<>();
        for(int i=0; i<heights.length;i++){
            if(stack.isEmpty()){
                op.add(-1);
            }else if(!stack.isEmpty() && stack.peek().getValue()<heights[i]){
                op.add(stack.peek().getIndex());
            }else{
                while(!stack.isEmpty() && stack.peek().getValue()>heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    op.add(-1);
                }else if(!stack.isEmpty() && stack.peek().getValue()<heights[i]){
                    op.add(stack.peek().getIndex());
                }
            }
            Element e = new Element(i, heights[i]);
            stack.push(e);
        }
        return op;
    }
}
