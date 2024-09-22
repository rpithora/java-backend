package com.shaurya._7stack;

import java.util.Arrays;
import java.util.Stack;

public class _5MinElementInStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public _5MinElementInStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        _5MinElementInStack minElementInStack = new _5MinElementInStack();
        String[] operations = {"MinStack", "push", "push", "push", "push", "pop", "getMin", "pop", "getMin", "pop", "getMin"};
        Integer[] arr = {null, 512, -1024, -1024, 512, null, null, null, null, null, null};
        Integer[] result = new Integer[arr.length];
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MinStack":
                    result[i] = null;
                    break;
                case "push":
                    minElementInStack.push(arr[i]);
                    result[i] = null;
                    break;
                case "pop":
                    minElementInStack.pop();
                    result[i] = null;
                    break;
                case "getMin":
                    result[i] = minElementInStack.getMin();
                    break;
                case "top":
                    result[i] = minElementInStack.top();
                    break;
            }
        }

        Arrays.stream(result).forEach(s -> System.out.print(s + " "));
    }

    public void push(int val) {
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
        stack.push(val);

        System.out.println("stack : " + stack);
        System.out.println("minStack : " + minStack);
        System.out.println();
    }

    public void pop() {
        if (!stack.isEmpty()) {
            System.out.println("stack.peek() == minStack.peek() : " + stack.peek() + " ::: " + minStack.peek());
            System.out.println("stack.peek() == minStack.peek() : " + stack.peek().equals(minStack.peek()));
            if (!minStack.isEmpty() && stack.peek().equals(minStack.peek())) {
                System.out.println("removing");
                minStack.pop();
            }
            stack.pop();
        }
        System.out.println("stack : " + stack);
        System.out.println("minStack : " + minStack);
        System.out.println();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}