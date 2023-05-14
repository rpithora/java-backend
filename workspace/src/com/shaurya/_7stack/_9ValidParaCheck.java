package com.shaurya._7stack;

import java.util.Stack;

public class _9ValidParaCheck {
    public static void main(String[] args) {
        _9ValidParaCheck paraCheck = new _9ValidParaCheck();
        String input = "{([])}" ;
        Thread t1 = new Thread(() -> System.out.println(paraCheck.solve(input)));

        Thread t2 = new Thread(() -> System.out.println(paraCheck.solve(input)));

        t1.start();
        t2.start();

        //System.out.println(paraCheck.solve("{([])}"));
    }
    public int solve(String A) {
        if(A == null || A.isEmpty())
            return 0;
        char[] arr = A.toCharArray();
        Stack<Character> s = new Stack();
        char c1 = ')';
        char c2 = '}';
        char c3 = ']';
        char c4 = '(';
        char c5 = '{';
        char c6 = '[';
        for(int i=0; i<arr.length; i++){
            if(arr[i] == c4 || arr[i] == c5 || arr[i] == c6){
                s.push(arr[i]);
            }else{
                if(arr[i] == c1){
                    if(!s.isEmpty() && s.peek() == c4){
                        s.pop();
                    }else{
                        return 0;
                    }
                }else if(arr[i] == c2){
                    if(!s.isEmpty() && s.peek() == c5){
                        s.pop();
                    }else{
                        return 0;
                    }
                }else if(arr[i] == c3){
                    if(!s.isEmpty() && s.peek() == c6){
                        s.pop();
                    }else{
                        return 0;
                    }
                }
            }
        }
        if(s.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
}

