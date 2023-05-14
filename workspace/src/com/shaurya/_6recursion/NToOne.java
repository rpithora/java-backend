package com.shaurya._6recursion;

public class NToOne {
    public static void main(String[] args) {
        int n = 10;
        solution(n);
    }

    private static void solution(int n) {
        if(n < 1){
            return;
        }
        System.out.println(n);
        solution(n-1);
    }
}
