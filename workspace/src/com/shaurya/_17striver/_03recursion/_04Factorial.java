package com.shaurya._17striver._03recursion;

public class _04Factorial {
    public static void main(String[] args) {
        int n = 5;
        int fact = fact(n);
        System.out.println(fact);
    }

    private static int fact(int n) {
        if (n == 0)
            return 1;

        return n * fact(n - 1);
    }
}
