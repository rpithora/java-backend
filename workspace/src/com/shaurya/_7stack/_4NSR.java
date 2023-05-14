package com.shaurya._7stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _4NSR {
    public static void main(String[] args) {
        int arr[] = {1,3,2,4};
        System.out.println(solution(arr));
    }

    private static List<Integer> solution(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        for(int i=arr.length-1; i>=0; i--){
            if(stack.isEmpty()){
                output.add(-1);
            }else if(!stack.isEmpty() && stack.peek() < arr[i]){
                output.add(stack.peek());
            }else{
                while (!stack.isEmpty() && stack.peek() > arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    output.add(-1);
                }else if(!stack.isEmpty() && stack.peek() < arr[i]){
                    output.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(output);
        return output;
    }
}