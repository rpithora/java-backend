package com.shaurya._6recursion;

public class MagicNumber {
    public static void main(String[] args) {
        MagicNumber magicNumber = new MagicNumber();
        System.out.println(magicNumber.solve(1291));
    }

    public int solve(int A) {
        if (A / 10 == 0) {
            return A == 1 ? 1 : 0;
        }
        do {
            A = sum(A);
        } while (A / 10 != 0);
        return A == 1 ? 1 : 0;
    }

    private int sum(int A) {
        if (A / 10 == 0) {
            return A;
        }

        return A % 10 + sum(A / 10);
    }
}

