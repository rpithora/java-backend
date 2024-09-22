package com.shaurya._17striver._3recursion;

public class _01PrintNameNTimes {
    public static void main(String[] args) {
        int n = 5;
        String name = "Shaurya-Shreya";
        print(name, n);
    }

    private static void print(String name, int n) {
        if (n == 0)
            return;
        System.out.println(name);
        print(name, n - 1);
    }
}
