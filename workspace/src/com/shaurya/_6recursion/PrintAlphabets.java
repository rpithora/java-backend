package com.shaurya._6recursion;

public class PrintAlphabets {
    public static void main(String[] args) {
        String s1 = "136" ;
        String op = "";
        solution(s1, op, s1.length());
    }

    private static void solution(String s1, String op, int n) {
        if(n == 0){
            System.out.println(op);
            return;
        }
        String op1 = op;
        String op2 = op;

        op1+=s1.substring(0,1);
        s1 = s1.substring(1);

        solution(s1, op1, s1.length());
        solution(s1, op2, s1.length());
    }
}
