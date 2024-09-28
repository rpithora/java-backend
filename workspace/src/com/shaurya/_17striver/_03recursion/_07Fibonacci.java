package com.shaurya._17striver._03recursion;

public class _07Fibonacci {
    public static void main(String[] args) {
        int num = 5;
        for (int i = 1; i <= num; i++) {
            int fib = findFib(i);
            System.out.print(fib + " ");
        }
    }

    private static int findFib(int num) {
        if (num <= 1)
            return num;
        return findFib(num - 1) + findFib(num - 2);
    }
}
