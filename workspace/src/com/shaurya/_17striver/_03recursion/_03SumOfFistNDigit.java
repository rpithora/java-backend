package com.shaurya._17striver._03recursion;

public class _03SumOfFistNDigit {
    public static void main(String[] args) {
        int number = 5;
        int total = sum1(number);
        System.out.println(total);

        sum2(number, 0);
    }

    private static void sum2(int number, int sum) {
        if (number == 0) {
            System.out.println(sum);
            return;
        }
        sum2(number - 1, sum + number);
    }

    private static int sum1(int number) {
        return (number * (number + 1)) / 2;
    }
}
