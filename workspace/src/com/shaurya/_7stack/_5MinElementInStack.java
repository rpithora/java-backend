package com.shaurya._7stack;

import java.util.Stack;

public class _5MinElementInStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        _5MinElementInStack minElementInStack = new _5MinElementInStack();
        int arr[] = {18, 19, 29, 15, 16} ;
        for(int i=0; i<arr.length; i++){
            minElementInStack.push(arr[i]);
        }
        int i = arr.length;
        while (i>0){
            minElementInStack.pop();
            i--;
        }
    }

    private void push(int ele) {
        if (!minStack.isEmpty() && minStack.peek() <= ele) {
            stack.push(ele);
        } else {
            stack.push(ele);
            minStack.push(ele);
        }
        System.out.print(stack.peek() + " ");
        System.out.print(minStack.peek());
        System.out.println();
    }

    private void pop() {
        if(stack.isEmpty()){
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Stack Top : "+minStack.peek());
        if(stack.peek() != minStack.peek()){
            System.out.println("removed element : "+stack.peek());
            stack.pop();
        }else{
            System.out.println("removed element : "+stack.peek());
            stack.pop();
            minStack.pop();
        }
    }
}
