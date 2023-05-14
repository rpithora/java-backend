package com.shaurya._6recursion;

public class PrintSubset {
    public static void main(String[] args) {
        String input = "AAB";
        String output = "";
        solution(input, output);
        System.out.println(cnt);
    }
    static int cnt = 0;
    private static void solution(String input, String output) {
        if(input.isEmpty()){
            System.out.println(output);
            if(output.equals("AG")){
                cnt++;
            }
            return;
        }

        String op1 = output;
        String op2 = output;

        op1+=input.substring(0,1);

        input = input.substring(1);

        solution(input, op1);
        solution(input, op2);

    }
}
