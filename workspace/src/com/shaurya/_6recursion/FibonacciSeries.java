package com.shaurya._6recursion;

public class FibonacciSeries {
    public static void main(String[] args) {
        int N = 5;
        for (int i = 0; i <= N; i++) {
            System.out.print(printFib(i) + " ");
        }
    }

    private static int printFib(int n) {
        if(n <= 1){
            return n;
        }

        return printFib(n-1) + printFib(n-2);
    }
}
