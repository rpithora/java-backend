package com.shaurya._6recursion;

public class PrintSubsetWithSpace {
    public static void main(String[] args) {
        String input = "ABC";
        String output = input.substring(0,1);;
        solution(input.substring(1,input.length()), output);
    }

    private static void solution(String input, String output) {
        if(input.isEmpty()){
            System.out.println(output);
            return;
        }

        String op1 = output;
        String op2 = output;

        op1+=" "+input.substring(0,1);
        op2+=input.substring(0,1);

        input = input.substring(1,input.length());

        solution(input, op1);
        solution(input, op2);

    }
}
