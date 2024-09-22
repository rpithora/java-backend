package com.shaurya._17striver._3recursion;

public class _02PrintNTo1 {
    public static void main(String[] args) {
        int num = 5;
        print1(num);
        print2(num);
    }

    private static void print1(int num) {
        if (num == 0)
            return;

        System.out.println(num);
        print1(num - 1);
    }

    private static void print2(int num) {
        if (num == 0)
            return;

        print2(num - 1);
        System.out.println(num);
    }
}
