package com.shaurya._6recursion;

public class PrintCaseChangePermutationWithInteger {
    public static void main(String[] args) {
        String input = "a1b2" ;
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
        char[] c = input.substring(0,1).toCharArray();
        if(Character.isDigit(c[0])){
            op1+=c[0];
            input = input.substring(1, input.length());
            solution(input, op1);
        }else {
            op1+=input.substring(0,1).toLowerCase();
            op2+=input.substring(0,1).toUpperCase();
            input = input.substring(1, input.length());
            solution(input, op1);
            solution(input, op2);
        }
    }
}
