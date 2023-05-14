package com.shaurya._6recursion;

public class OneToN {
    public static void main(String[] args) {
        int n = 10;
        solution(n);
    }

    private static void solution(int n) {
        if(n<1){
            return;
        }
        solution(n-1);
        System.out.println(n);
    }
}
