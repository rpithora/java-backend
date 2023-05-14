package com.shaurya._6recursion;

public class PrintCaseChangePermutation {
    public static void main(String[] args) {
        String input = "ABC" ;
        String output = "" ;
        solution(input, output);
    }

    private static void solution(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }

        String op1 = output;
        String op2 = output;

        op1+=input.substring(0,1).toLowerCase();
        op2+=input.substring(0,1).toUpperCase();

        input = input.substring(1);
        solution(input, op1);
        solution(input, op2);
    }
}
