package com.shaurya._7stack;

import java.util.*;

public class _10Solution {

    public static void main(String[] args) {
        _10Solution solution = new _10Solution();
        Integer a[] = new Integer[] { 6, 2, 5, 4, 5, 1, 6 };
        List<Integer> in = Arrays.asList(a);
        System.out.println(solution.largestRectangleArea(in));
    }

    class Pair{
        int val;
        int index;
        public Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
        public int getVal(){
            return val;
        }
        public int getIndex(){
            return index;
        }
    }
    public int largestRectangleArea(List<Integer> A) {
        if(!A.isEmpty() && A.size()==1){
            return A.get(0);
        }
        List<Integer> nsr = getNsr(A);
        System.out.println(nsr);
        List<Integer> nsl = getNsl(A);
        System.out.println(nsl);
        List<Integer> width = new ArrayList();
        for(int i=0; i<A.size(); i++){
            width.add((nsr.get(i) - nsl.get(i) - 1) * A.get(i));
        }
        System.out.println(width);
        return width.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
    }
    private List<Integer> getNsr(List<Integer> A){
        Stack<Pair> stack = new Stack();
        List<Integer> al = new ArrayList();
        for(int i=A.size()-1; i>=0; i--){
            if(stack.isEmpty()){
                al.add(A.size());
            }else if(!stack.isEmpty() && stack.peek().getVal() < A.get(i)){
                al.add(stack.peek().getIndex());
            }else{
                while(!stack.isEmpty() && stack.peek().getVal() >= A.get(i)){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    al.add(A.size());
                }else if(!stack.isEmpty() && stack.peek().getVal() < A.get(i)){
                    al.add(stack.peek().getIndex());
                }
            }
            Pair p = new Pair(A.get(i), i);
            stack.push(p);
        }
        Collections.reverse(al);
        return al;
    }
    private List<Integer> getNsl(List<Integer> A){
        Stack<Pair> stack = new Stack();
        List<Integer> al = new ArrayList();
        for(int i=0; i<A.size(); i++){
            if(stack.isEmpty()){
                al.add(-1);
            }else if(!stack.isEmpty() && stack.peek().getVal() < A.get(i)){
                al.add(stack.peek().getIndex());
            }else{
                while(!stack.isEmpty() && stack.peek().getVal() >= A.get(i)){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    al.add(-1);
                }else if(!stack.isEmpty() && stack.peek().getVal() < A.get(i)){
                    al.add(stack.peek().getIndex());
                }
            }
            Pair p = new Pair(A.get(i), i);
            stack.push(p);
        }
        return al;
    }
}