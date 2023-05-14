package com.shaurya._6recursion;

public class Pattern {
    public static void main(String[] args) {
        int n = 5 ;
        solution(n);
    }

    private static void solution(int n) {
        System.out.print(n + " ");
        if(n == 1){
            return;
        }
        solution(n-1);
        System.out.print(n + " ");
    }
}
