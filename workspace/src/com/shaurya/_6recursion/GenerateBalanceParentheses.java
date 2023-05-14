package com.shaurya._6recursion;

public class GenerateBalanceParentheses {
    public static void main(String[] args) {
        int n = 2;
        String output = "" ;
        int open = n, close = n ;
        solution(open, close, output);
    }

    private static void solution(int open, int close, String output) {
        if(open == 0 && close == 0){
            System.out.println(output);
            return;
        }

        String op1 = output;
        String op2 = output;

        if(open > 0){
            op1+="(";
            solution(open-1, close, op1);
        }

        if(close > open){
            op2+=")";
            solution(open, close-1, op2);
        }
    }
}
